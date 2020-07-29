package ru.spliterash.vkchat.db.model;

import lombok.*;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PlayerModel {

    private UUID UUID;

    private String nickname;

    private int vk;
    private Integer selectedConversation;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerModel model = (PlayerModel) o;
        return vk == model.vk &&
                Objects.equals(UUID, model.UUID) &&
                Objects.equals(nickname, model.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID, nickname, vk);
    }

    public AbstractPlayer getOnlinePlayer() {
        return VkChat.getInstance().getLauncher().getPlayer(getUUID());
    }

    public void saveOrUpdate() {
        DatabaseLoader.getBase().updateOrSaveMePls(this);
    }

    public ConversationModel getSelectedConversationModel() {
        if (selectedConversation != null)
            return DatabaseLoader.getBase().getConversationById(selectedConversation);
        else
            return null;
    }

    public void delete() {
        DatabaseLoader.getBase().deleteMe(this);
    }
}
