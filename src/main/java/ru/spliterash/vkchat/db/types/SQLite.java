package ru.spliterash.vkchat.db.types;

import org.intellij.lang.annotations.Language;
import ru.spliterash.vkchat.db.AbstractBase;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite extends AbstractBase {
    private final File file;

    public SQLite(File file) {
        this.file = file;
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                throw new IllegalArgumentException("File write error: " + file);
            }
        }
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("jdbc driver unavailable!");
        }
        afterInit();
    }


    @Override
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + file);
    }

    @Override
    @Language("SQLite")
    protected String getPlayerModelUpdateCreateQuery() {
        return "REPLACE INTO players (uuid, vk, nickname, selected_conversation)\n" +
                "values (:uuid, :vk, :nickname, :selected_conversation)";
    }

    @Override
    @Language("SQLite")
    protected String getConversationModelUpdateCreateQuery() {
        return "REPLACE INTO conversations (id, owner, title, invite_link)\n" +
                "values (:id, :owner, :title, :link)";
    }
}
