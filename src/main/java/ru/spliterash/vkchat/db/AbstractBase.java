package ru.spliterash.vkchat.db;

import org.intellij.lang.annotations.Language;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.db.utils.NamedParamStatement;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.StringUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractBase {

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
            return StringUtils.getString(getClass().getResourceAsStream(getClass().getSimpleName() + ".sql"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Connection getConnection() throws SQLException;

    protected PreparedStatement prepare(String query, Object... args) throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
                return statement;
            }
        }
    }

    protected ResultSet query(@Language("SQL") String query, Object... args) throws SQLException {
        return prepare(query, args).executeQuery();
    }

    protected int update(NamedParamStatement statement) {
        try (Connection connection = getConnection()) {
            return statement.executeUpdate(connection);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    protected int update(@Language("SQL") String query, Object... args) throws SQLException {
        return prepare(query, args).executeUpdate();
    }

    private PlayerModel extractPlayer(ResultSet set) throws SQLException {
        return new PlayerModel(
                UUID.fromString(set.getString("uuid")),
                set.getString("nickname"),
                set.getInt("vk"),
                set.getInt("selected_conversation")
        );
    }

    public ConversationModel getConversationById(int id) {
        try {
            ResultSet set = query("SELECT id, owner, title, invite_link FROM conversations where id = ?", id);
            return extractConversation(set);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    private ConversationModel extractConversation(ResultSet set) throws SQLException {
        return new ConversationModel(
                set.getInt("id"),
                UUID.fromString(set.getString("owner")),
                set.getString("title"),
                set.getString("invite_link")
        );
    }

    public PlayerModel getPlayerByUUID(UUID uuid) {
        try {
            ResultSet result = query(
                    "SELECT P.uuid,P.nickname ,P.vk, P.selected_conversation\n" +
                            "FROM players P\n" +
                            "WHERE uuid = ?", uuid.toString());
            if (result.next()) {
                return extractPlayer(result);
            } else
                return null;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public List<PlayerModel> getPlayerByVk(int... ids) {
        NamedParamStatement statement = new NamedParamStatement("SELECT P.uuid,P.nickname ,P.vk, P.selected_conversation\n" +
                "FROM players P\n" +
                "WHERE vk in (:vk)");
        statement.setValues("vk", ids);
        try {
            ResultSet set = query(statement);
            List<PlayerModel> list = new ArrayList<>(ArrayUtils.setSize(set));
            while (set.next()) {
                list.add(extractPlayer(set));
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    private ResultSet query(NamedParamStatement statement) throws SQLException {
        try (Connection connection = getConnection()) {
            return statement.executeQuery(connection);
        }
    }

    public PlayerModel getPlayerByVk(int id) {
        List<PlayerModel> result = getPlayerByVk(new int[]{id});
        if (result.size() == 1)
            return result.get(0);
        else
            return null;
    }

    public List<ConversationModel> getPlayerMemberConversation(UUID player) {
        try {
            List<ConversationModel> list = new ArrayList<>();
            ResultSet set = query("SELECT id, owner, title, invite_link\n" +
                    "from conversation_members cm\n" +
                    "join conversations c on cm.conversation = c.id\n" +
                    "where player = ?", player);
            while (set.next()) {
                list.add(extractConversation(set));
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    protected abstract String getPlayerModelUpdateCreateQuery();

    public void updateOrSaveMePls(PlayerModel model) {
        NamedParamStatement statement = new NamedParamStatement(getPlayerModelUpdateCreateQuery());
        statement.setValue("uuid", model.getUuid());
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
            update("DELETE FROM players where uuid = ?", model.getUuid().toString());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public List<PlayerModel> getConversationMembers(int peerId) {
        try {
            List<PlayerModel> list = new ArrayList<>();
            ResultSet set = query(
                    "SELECT P.uuid, P.nickname, P.vk, P.selected_conversation\n" +
                            "from conversation_members CM\n" +
                            "JOIN players P on CM.player = P.uuid where cm.conversation = ?", peerId);
            while (set.next()) {
                list.add(extractPlayer(set));
            }
            return list;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void deleteMe(ConversationModel model) {
        try {
            update("DELETE FROM conversations where id = ?", model.getId());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public void addMember(PlayerModel player, ConversationModel conversation) {
        try {
            update("INSERT INTO conversation_members (player, conversation) values (?,?)", player.getUuid(), conversation.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeMember(PlayerModel player, ConversationModel conversation) {
        try {
            update("DELETE FROM conversation_members WHERE player = ? AND  conversation = ?", player.getUuid(), conversation.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
