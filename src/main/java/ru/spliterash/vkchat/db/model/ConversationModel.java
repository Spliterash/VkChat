package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.utils.VkUtils;

import java.sql.SQLException;

@NoArgsConstructor
@Getter
@DatabaseTable(tableName = "conversations", daoClass = ConversationDao.class)
public class ConversationModel {
    public static final String ID_NAME = "id";
    @DatabaseField(id = true, columnName = ID_NAME)
    private int id;
    @DatabaseField(foreign = true)
    private PlayerModel owner;
    @DatabaseField
    @Setter
    private String title;
    @DatabaseField(columnName = "invite_link")
    private String inviteLink;

    public ConversationModel(int id, PlayerModel owner, String inviteLink) {
        this.id = id;
        this.title = "Unknown";
        this.owner = owner;
        this.inviteLink = inviteLink;
    }

    public void updateLink() throws ClientException, ApiException, SQLException {
        inviteLink = VkUtils.getInviteLink(id);
        saveOrUpdate();
    }

    public void saveOrUpdate() throws SQLException {
        Database.getDao(ConversationModel.class).createOrUpdate(this);
    }
}
