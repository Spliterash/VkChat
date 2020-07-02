package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.utils.VkUtils;

import java.sql.SQLException;
import java.util.Collection;

@NoArgsConstructor
@Getter
@DatabaseTable(tableName = "conversations", daoClass = ConversationDao.class)
public class ConversationModel {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(foreign = true)
    private PlayerModel owner;
    @DatabaseField(columnName = "invite_link")
    private String inviteLink;
    @ForeignCollectionField
    private ForeignCollection<PlayerModel> members;

    public ConversationModel(int id, PlayerModel owner, String inviteLink) {
        this.id = id;
        this.owner = owner;
        this.inviteLink = inviteLink;
    }

    public void updateLink() throws ClientException, ApiException, SQLException {
        inviteLink = VkUtils.getInviteLink(id);
        saveOrUpdate();
    }

    public void updateMembers(Collection<PlayerModel> list) throws SQLException {
        members.clear();
        members.addAll(list);
        saveOrUpdate();
    }

    public void saveOrUpdate() throws SQLException {
        Database.getDao(ConversationModel.class).createOrUpdate(this);
    }
}
