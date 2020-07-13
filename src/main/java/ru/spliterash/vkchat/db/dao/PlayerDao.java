package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public List<PlayerModel> queryForVkMultiply(int... ids) {
        Set<Integer> set = new HashSet<>(ids.length);
        for (int id : ids) {
            set.add(id);
        }
        try {
            return queryBuilder()
                    .where()
                    .in("vk", set)
                    .query();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public List<ConversationModel> queryForConversation(PlayerModel pModel) {
        return null;
    }
}
