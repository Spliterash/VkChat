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
    protected String getCreationScript() {
        return "-- MySQL Script generated by MySQL Workbench\n" +
                "-- Tue Jul 28 00:54:52 2020\n" +
                "-- Model: New Model    Version: 1.0\n" +
                "-- MySQL Workbench Forward Engineering\n" +
                "\n" +
                "SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;\n" +
                "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;\n" +
                "SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';\n" +
                "\n" +
                "-- -----------------------------------------------------\n" +
                "-- Schema mydb\n" +
                "-- -----------------------------------------------------\n" +
                "\n" +
                "-- -----------------------------------------------------\n" +
                "-- Table `players`\n" +
                "-- -----------------------------------------------------\n" +
                "CREATE TABLE IF NOT EXISTS `players` (\n" +
                "  `uuid` VARCHAR(64) NOT NULL,\n" +
                "  `vk` INT NOT NULL,\n" +
                "  `nickname` VARCHAR(64) NOT NULL,\n" +
                "  PRIMARY KEY (`uuid`),\n" +
                "  UNIQUE INDEX `vk_UNIQUE` (`vk` ASC) VISIBLE)\n" +
                "ENGINE = InnoDB;\n" +
                "\n" +
                "\n" +
                "-- -----------------------------------------------------\n" +
                "-- Table `conversations`\n" +
                "-- -----------------------------------------------------\n" +
                "CREATE TABLE IF NOT EXISTS `conversations` (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `owner` VARCHAR(64) NOT NULL,\n" +
                "  `title` VARCHAR(256) NULL,\n" +
                "  `invite_link` VARCHAR(128) NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_conversations_players_idx` (`owner` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_conversations_players`\n" +
                "    FOREIGN KEY (`owner`)\n" +
                "    REFERENCES `players` (`uuid`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;\n" +
                "\n" +
                "\n" +
                "-- -----------------------------------------------------\n" +
                "-- Table `conversation_members`\n" +
                "-- -----------------------------------------------------\n" +
                "CREATE TABLE IF NOT EXISTS `conversation_members` (\n" +
                "  `player` VARCHAR(64) NOT NULL,\n" +
                "  `conversation` INT NOT NULL,\n" +
                "  PRIMARY KEY (`player`, `conversation`),\n" +
                "  INDEX `fk_players_has_conversations_conversations1_idx` (`conversation` ASC) VISIBLE,\n" +
                "  INDEX `fk_players_has_conversations_players1_idx` (`player` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_players_has_conversations_players1`\n" +
                "    FOREIGN KEY (`player`)\n" +
                "    REFERENCES `players` (`uuid`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_players_has_conversations_conversations1`\n" +
                "    FOREIGN KEY (`conversation`)\n" +
                "    REFERENCES `conversations` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;\n" +
                "\n" +
                "\n" +
                "SET SQL_MODE=@OLD_SQL_MODE;\n" +
                "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;\n" +
                "SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;\n";
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