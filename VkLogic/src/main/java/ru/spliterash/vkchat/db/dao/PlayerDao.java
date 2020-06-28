package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;
import java.util.UUID;

public class PlayerDao extends BaseDaoImpl<PlayerModel, UUID> {
    protected PlayerDao(JdbcPooledConnectionSource connectionSource) throws SQLException {
        super(connectionSource,PlayerModel.class);
    }
}
