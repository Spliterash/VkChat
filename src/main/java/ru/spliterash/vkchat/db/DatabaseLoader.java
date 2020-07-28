package ru.spliterash.vkchat.db;

import lombok.Getter;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.types.MySQL;
import ru.spliterash.vkchat.db.types.SQLite;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;


public class DatabaseLoader {
    private static DatabaseLoader instance = new DatabaseLoader();
    private final AbstractBase base;

    public static void reload() {
        instance = new DatabaseLoader();
    }

    public static AbstractBase getBase() {
        return instance.base;
    }

    private DatabaseLoader() {
        AbstractConfig config = VkChat.getInstance().getLauncher().getVkConfig();
        if (config.getBoolean("mysql_enable", false))
            base = new SQLite(new File(VkChat.getInstance().getLauncher().getDataFolder(), "base.db"));
        else
            base = new MySQL(
                    config.getString("mysql_host"),
                    config.getString("mysql_port"),
                    config.getString("mysql_db"),
                    config.getString("mysql_user"),
                    config.getString("mysql_password")
            );
    }

    private void loadSQLite() {

    }


}
