package ru.spliterash.vkchat.db.model;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.utils.VkUtils;

import java.sql.SQLException;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class ConversationModel {
    private final int id;
    private final UUID owner;
    @Setter
    private String title;
    private String inviteLink;


    public void updateLink() throws ClientException, ApiException, SQLException {
        inviteLink = VkUtils.getInviteLink(id);
        saveOrUpdate();
    }

    public void saveOrUpdate() {
        DatabaseLoader.getBase().updateOrSaveMePls(this);
    }

    public PlayerModel getOwnerModel() {
        return DatabaseLoader.getBase().getPlayerByUUID(getOwner());
    }

    public void delete() {
        DatabaseLoader.getBase().deleteMe(this);
    }
}
