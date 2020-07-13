package ru.spliterash.vkchat.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.Getter;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Getter
public class Database {
    @Getter
    private static Database instance;
    private final JdbcPooledConnectionSource connectionSource;

    private Database() {
        File dbFile = new File(VkChat.getInstance().getLauncher().getDataFolder(), "base.db");
        try {
            connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:" + dbFile);
            TableUtils.createTableIfNotExists(connectionSource, PlayerModel.class);
            TableUtils.createTableIfNotExists(connectionSource, ConversationModel.class);
            TableUtils.createTableIfNotExists(connectionSource, PlayerConversationModel.class);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }

    public static <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) {
        try {
            return DaoManager.createDao(getInstance().connectionSource, clazz);
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
