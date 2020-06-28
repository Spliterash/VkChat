package ru.spliterash.vkchat.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.Getter;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Getter
public class Database {
    @Getter
    private static Database instance = new Database();
    private final JdbcPooledConnectionSource connectionSource;

    private Database() {
        File dbFile = new File(VkChat.getInstance().getLauncher().getDataFolder(), "base.db");
        try {
            connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:" + dbFile);
            TableUtils.createTableIfNotExists(connectionSource, PlayerModel.class);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    public <D extends Dao<T, ?>, T> D getDao(ConnectionSource connectionSource, Class<T> clazz) {
        try {
            return DaoManager.createDao(connectionSource, clazz);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public static void reload() {
        if (instance != null)
            instance.close();
        instance = new Database();
    }

    public void close() {
        try {
            connectionSource.close();
            instance = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}