package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import ru.spliterash.vkchat.db.dao.PlayerConversationDao;

@Getter
@DatabaseTable(tableName = "player_conversation", daoClass = PlayerConversationDao.class)
public class PlayerConversationModel {
    public final static String USER_UUID_FIELD_NAME = "player_uuid";
    public final static String CONVERSATION_ID_FIELD_NAME = "conversation_id";

    @DatabaseField(foreign = true, columnName = USER_UUID_FIELD_NAME)
    private PlayerModel player;
    @DatabaseField(foreign = true, columnName = CONVERSATION_ID_FIELD_NAME)
    private ConversationModel conversation;
}
