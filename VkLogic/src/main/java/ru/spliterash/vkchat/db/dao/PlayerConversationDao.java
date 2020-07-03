package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static ru.spliterash.vkchat.db.Database.getDao;

public class PlayerConversationDao extends BaseDaoImpl<PlayerConversationModel, Void> {

    public PlayerConversationDao(ConnectionSource connectionSource, Class<PlayerConversationModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<PlayerModel> queryForConversation(ConversationModel model) throws SQLException {
        QueryBuilder<PlayerConversationModel, Void> playersUUUIDs = queryBuilder();
        playersUUUIDs
                .selectColumns(PlayerConversationModel.USER_UUID_FIELD_NAME)
                .where()
                .eq(PlayerConversationModel.CONVERSATION_ID_FIELD_NAME, model.getId());
        PlayerDao dao = getDao(PlayerModel.class);
        return dao
                .queryBuilder()
                .where()
                .in(PlayerModel.UUID_NAME, playersUUUIDs)
                .query();
    }

    public List<PlayerConversationModel> findByPlayer(UUID playerUuid) throws SQLException {
        return queryBuilder()
                .where()
                .eq(PlayerConversationModel.USER_UUID_FIELD_NAME, playerUuid)
                .query();
    }

    public List<PlayerConversationModel> findByConversation(long id) throws SQLException {
        return queryBuilder()
                .where()
                .eq(PlayerConversationModel.CONVERSATION_ID_FIELD_NAME,id)
                .query();
    }

    public List<ConversationModel> queryForPlayer(PlayerModel model) throws SQLException {
        QueryBuilder<PlayerConversationModel, Void> conversationIds = queryBuilder();
        conversationIds
                .selectColumns(PlayerConversationModel.CONVERSATION_ID_FIELD_NAME)
                .where()
                .eq(PlayerConversationModel.USER_UUID_FIELD_NAME, model.getUuid());
        ConversationDao dao = getDao(ConversationModel.class);
        return dao
                .queryBuilder()
                .where()
                .in(ConversationModel.ID_NAME, conversationIds)
                .query();
    }
}
