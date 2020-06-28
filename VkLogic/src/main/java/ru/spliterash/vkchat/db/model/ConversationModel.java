package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import ru.spliterash.vkchat.db.dao.ConversationDao;

@DatabaseTable(tableName = "conversations",daoClass = ConversationDao.class)
public class ConversationModel {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "invite_link")
    private String inviteLink;
}
