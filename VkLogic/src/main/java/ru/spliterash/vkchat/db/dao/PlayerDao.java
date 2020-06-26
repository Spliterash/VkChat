package ru.spliterash.vkchat.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.sql.SQLException;

public class PlayerDao extends BaseDaoImpl<PlayerModel, Long> {
    protected PlayerDao(JdbcPooledConnectionSource connectionSource) throws SQLException {
        super(connectionSource,PlayerModel.class);
    }
}
