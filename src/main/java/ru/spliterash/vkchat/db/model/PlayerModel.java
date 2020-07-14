package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.*;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@DatabaseTable(tableName = "players", daoClass = PlayerDao.class)
public class PlayerModel {
    public static final String UUID_NAME = "uuid";
    public static final String SELECTED_NAME = "selected_conversation";

    @DatabaseField(columnName = UUID_NAME, id = true, index = true, canBeNull = false, unique = true)
    private UUID uuid;
    @DatabaseField
    private String nickname;
    @DatabaseField(canBeNull = false, unique = true)
    private int vk;
    @DatabaseField(foreign = true, columnName = SELECTED_NAME)
    private ConversationModel selectedConversation;

    public PlayerModel(UUID uuid, String nickname, int vk) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.vk = vk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerModel model = (PlayerModel) o;
        return vk == model.vk &&
                Objects.equals(uuid, model.uuid) &&
                Objects.equals(nickname, model.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, nickname, vk);
    }

    public AbstractPlayer getOnlinePlayer() {
        return VkChat.getInstance().getLauncher().getPlayer(getUuid());
    }
}
