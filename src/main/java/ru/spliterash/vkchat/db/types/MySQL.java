package ru.spliterash.vkchat.db.types;

import org.intellij.lang.annotations.Language;
import ru.spliterash.vkchat.db.AbstractBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL extends AbstractBase {
    private final String password;
    private final String db;
    private final String host;
    private final String user;
    private final String port;

    public MySQL(String host, String port, String db, String user, String password) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found");
        }
        afterInit();
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
    }

    @Override
    @Language("MySQL")
    protected String getPlayerModelUpdateCreateQuery() {
        return "INSERT INTO players (uuid, vk, nickname, selected_conversation)\n" +
                "values (:uuid, :vk, :nickname, :selected_conversation)\n" +
                "on duplicate key update vk                    = :vk,\n" +
                "                        nickname              = :nickname,\n" +
                "                        selected_conversation = :selected_conversation";
    }

    @Override
    @Language("MySQL")
    protected String getConversationModelUpdateCreateQuery() {
        return "INSERT INTO conversations (id, owner, title, invite_link)\n" +
                "values (:id, :owner, :title, :link)\n" +
                "on duplicate key update owner       = :owner,\n" +
                "                              title       = :title,\n" +
                "                              invite_link = :link;";
    }
}
