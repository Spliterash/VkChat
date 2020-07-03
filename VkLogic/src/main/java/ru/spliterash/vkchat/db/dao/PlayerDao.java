package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PlayerDao extends BaseDaoImpl<PlayerModel, UUID> {

    public PlayerDao(ConnectionSource connectionSource, Class<PlayerModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public PlayerModel queryForVk(int id) {
        try {
            return queryBuilder()
                    .where()
                    .eq("vk", id)
                    .queryForFirst();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public List<ConversationModel> queryForConversation(PlayerModel pModel) {
        return null;
    }
}
