package ru.spliterash.vkchat.db.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DatabaseTable(tableName = "players", daoClass = PlayerDao.class)
public class PlayerModel {
    public static final String UUID_NAME = "uuid";

    @DatabaseField(columnName = UUID_NAME, id = true, index = true, canBeNull = false, unique = true)
    private UUID uuid;
    @DatabaseField
    private String nickname;
    @DatabaseField(canBeNull = false, unique = true)
    private int vk;

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
