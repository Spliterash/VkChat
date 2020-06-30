package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.UUID;

public class PlayerDao extends BaseDaoImpl<PlayerModel, UUID> {
    protected PlayerDao(JdbcPooledConnectionSource connectionSource) throws SQLException {
        super(connectionSource, PlayerModel.class);
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
}
