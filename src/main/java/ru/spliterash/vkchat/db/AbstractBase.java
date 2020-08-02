package ru.spliterash.vkchat.db;

import org.intellij.lang.annotations.Language;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.db.model.ResultSetRow;
import ru.spliterash.vkchat.db.utils.NamedParamStatement;
import ru.spliterash.vkchat.utils.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public abstract class AbstractBase {
    private final String name;

    protected AbstractBase(String name) {
        this.name = name;
    }

    public List<String> getColumns(ResultSet set) throws SQLException {
        ResultSetMetaData meta = set.getMetaData();
        List<String> list = new ArrayList<>(meta.getColumnCount());
        for (int i = 0; i < meta.getColumnCount(); i++) {
            list.add(meta.getColumnName(i + 1));
        }
        return list;
    }

    public Set<ResultSetRow> extractSet(ResultSet set) throws SQLException {
        Set<ResultSetRow> mapButSet = Collections.newSetFromMap(new LinkedHashMap<>());
        List<String> columns = getColumns(set);
        while (set.next()) {
            ResultSetRow row = new ResultSetRow();
            for (String column : columns) {
                row.put(column, set.getObject(column));
            }
            mapButSet.add(row);
        }
        return mapButSet;
    }

    protected void afterInit() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            for (String s : getCreationScript().split(";")) {
                statement.executeUpdate(s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Language("SQL")
    protected String getCreationScript() {
        try {
            String fileName = name + ".sql";
            String path = "db/" + fileName;
            InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
            return StringUtils.getString(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void setValue(PreparedStatement statement, int i, T obj) throws SQLException {
        int index = i + 1;
        if (obj instanceof String)
            statement.setString(index, (String) obj);
        else if (obj instanceof Double)
            statement.setDouble(index, (double) obj);
        else if (obj instanceof Integer)
            statement.setInt(index, (Integer) obj);
        else if (obj instanceof Date)
            statement.setDate(index, (Date) obj);
        else if (obj instanceof Long)
            statement.setLong(index, (Long) obj);
        else
            statement.setObject(index, obj);

    }

    protected abstract Connection getConnection() throws SQLException;

    protected PreparedStatement prepare(Connection connection, String query, Object... args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < args.length; i++) {
            setValue(statement, i, args[i]);
        }
        return statement;

    }

    protected Set<ResultSetRow> query(@Language("SQL") String query, Object... args) {
        try (
                Connection connection = getConnection();
                PreparedStatement prepared = prepare(connection, query, args)
        ) {
            return extractSet(prepared.executeQuery());
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    protected int update(NamedParamStatement statement) {
        try (Connection connection = getConnection()) {
            return statement.executeUpdate(connection);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    protected int update(@Language("SQL") String query, Object... args) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement prepared = prepare(connection, query, args)
        ) {
            return prepared.executeUpdate();
        }
    }

    private PlayerModel extractPlayer(ResultSetRow set) {
        return new PlayerModel(
                UUID.fromString(set.getString("uuid")),
                set.getString("nickname"),
                set.getInt("vk"),
                set.getInt("selected_conversation")
        );
    }

    public ConversationModel getConversationById(int id) {
        Set<ResultSetRow> set = query("SELECT id, owner, title, invite_link FROM conversations where id = ?", id);
        for (ResultSetRow row : set) {
            return extractConversation(row);
        }
        return null;
    }

    private ConversationModel extractConversation(ResultSetRow set) {
        return new ConversationModel(
                set.getInt("id"),
                UUID.fromString(set.getString("owner")),
                set.getString("title"),
                set.getString("invite_link")
        );
    }

    public PlayerModel getPlayerByUUID(UUID uuid) {
        Set<ResultSetRow> result = query(
                "SELECT uuid,nickname ,vk, selected_conversation\n" +
                        "FROM players\n" +
                        "WHERE uuid = ?", uuid.toString());
        if (result.size() > 0) {
            for (ResultSetRow map : result) {
                return extractPlayer(map);
            }
        }
        return null;
    }

    public List<PlayerModel> getPlayerByVk(Integer[] ids) {
        NamedParamStatement statement = new NamedParamStatement("SELECT P.uuid,P.nickname ,P.vk, P.selected_conversation\n" +
                "FROM players P\n" +
                "WHERE vk in (:vk)");
        statement.setValues("vk", ids);
        try {
            Set<ResultSetRow> set = query(statement);
            List<PlayerModel> list = new ArrayList<>();
            for (ResultSetRow row : set) {
                list.add(extractPlayer(row));
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    private Set<ResultSetRow> query(NamedParamStatement statement) throws SQLException {
        try (Connection connection = getConnection()) {
            return extractSet(statement.executeQuery(connection));
        }
    }

    public PlayerModel getPlayerByVk(int id) {
        List<PlayerModel> result = getPlayerByVk(new Integer[]{id});
        if (result.size() == 1)
            return result.get(0);
        else
            return null;
    }

    private List<ConversationModel> listConversation(@Language("SQL") String query, Object... args) {
        Set<ResultSetRow> set = query(query, args);
        List<ConversationModel> list = new ArrayList<>();

        for (ResultSetRow row : set) {
            list.add(extractConversation(row));
        }
        return list;
    }

    public List<ConversationModel> getPlayerAdminConversation(UUID player) {
        return listConversation("SELECT id, owner, title, invite_link\n" +
                "from conversations\n" +
                "where owner = ?", player.toString());
    }

    public List<ConversationModel> getPlayerMemberConversation(UUID player) {
        return listConversation("SELECT id, owner, title, invite_link\n" +
                "from conversation_members cm\n" +
                "join conversations c on cm.conversation = c.id\n" +
                "where player = ?", player.toString());
    }

    protected abstract String getPlayerModelUpdateCreateQuery();

    public void updateOrSaveMePls(PlayerModel model) {
        NamedParamStatement statement = new NamedParamStatement(getPlayerModelUpdateCreateQuery());
        statement.setValue("uuid", model.getUUID());
        statement.setValue("vk", model.getVk());
        statement.setValue("nickname", model.getNickname());
        statement.setValue("selected_conversation", model.getSelectedConversation());
        update(statement);
    }

    protected abstract String getConversationModelUpdateCreateQuery();

    public void updateOrSaveMePls(ConversationModel model) {
        NamedParamStatement statement = new NamedParamStatement(getConversationModelUpdateCreateQuery());
        statement.setValue("id", model.getId());
        statement.setValue("link", model.getInviteLink());
        statement.setValue("owner", model.getOwner());
        statement.setValue("title", model.getTitle());
        update(statement);
    }


    public void deleteMe(PlayerModel model) {
        try {
            String uuid = model.getUUID().toString();
            update("DELETE FROM players where uuid = ?", uuid);
            update("DELETE FROM conversations where owner = ?", uuid);
            update("DELETE FROM conversation_members where player = ?", uuid);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public List<PlayerModel> getConversationMembers(int peerId) {
        Set<ResultSetRow> set = query(
                "SELECT P.uuid, P.nickname, P.vk, P.selected_conversation\n" +
                        "from conversation_members CM\n" +
                        "JOIN players P on CM.player = P.uuid where cm.conversation = ?", peerId);
        List<PlayerModel> list = new ArrayList<>();

        for (ResultSetRow row : set) {
            list.add(extractPlayer(row));
        }
        return list;
    }

    public void deleteMe(ConversationModel model) {
        try {
            int id = model.getId();
            update("DELETE FROM conversations where id = ?", id);
            update("DELETE FROM conversation_members where conversation = ?", id);
            update("UPDATE players set selected_conversation = null where selected_conversation = ?", id);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void addMember(PlayerModel player, ConversationModel conversation) {
        try {
            update("INSERT INTO conversation_members (player, conversation) values (?,?)", player.getUUID(), conversation.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeMember(PlayerModel player, ConversationModel conversation) {
        try {
            update("DELETE FROM conversation_members WHERE player = ? AND  conversation = ?", player.getUUID(), conversation.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
