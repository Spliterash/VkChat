package ru.spliterash.vkchat.utils;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.users.UserFull;
import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class VkUtils {
    private final String EXECUTE_ID_CODE = "var l = API.photos.getMessagesUploadServer().upload_url;\n" +
            "var i = l.indexOf(\"gid\");\n" +
            "if (l.indexOf(\"gid=0\") == -1)\n" +
            "{\n" +
            "    return {\"type\":\"group\",\n" +
            "            \"id\":parseInt(l.substr(i + 4, l.length - i + 4).split(\"&\")[0])};\n" +
            "} else {\n" +
            "    i = l.indexOf(\"mid\");\n" +
            "    return {\"type\":\"user\",\n" +
            "            \"id\":parseInt(l.substr(i + 4, l.length - i + 4).split(\"&\")[0])};\n" +
            "}";

    public int getMyId(String token) throws ClientException, ApiException {
        GroupActor anonActor = new GroupActor(null, token);
        JsonObject result = VkChat
                .getExecutor()
                .execute()
                .code(anonActor, EXECUTE_ID_CODE)
                .execute()
                .getAsJsonObject();
        if (result.get("type").getAsString().equals("group")) {
            return result.get("id").getAsInt();
        } else
            throw new RuntimeException("Token is not group token\n" + result.toString());
    }

    /**
     * Создаёт новую беседу
     *
     * @return ID новой беседы если ок, если ошибка вылетит exception
     */
    public int createNewConversation() throws ClientException, ApiException {
        VkChat vk = VkChat.getInstance();
        VkApiClient executor = VkChat.getExecutor();
        int id = executor
                .messages()
                .createChat(vk.getActor())
                .userIds()
                .title("VkChat")
                .execute();
        return id + 2000000000;
    }

    public String getInviteLink(int peerId) throws ClientException, ApiException {
        if (!isConversation(peerId))
            throw new RuntimeException("It not conversation");
        VkChat vk = VkChat.getInstance();
        VkApiClient executor = VkChat.getExecutor();
        return executor
                .messages()
                .getInviteLink(vk.getActor(), peerId)
                .execute()
                .getLink();
    }

    public TextComponent getGroupComponent(GroupFull group) {
        if (group == null) {
            return ComponentUtils.getNullComponent();
        }
        String description = group.getDescription();
        List<String> list = Lang.GROUP_HOVER.toList();
        ArrayUtils.replaceOrRemove(list, "{description}", description);
        BaseComponent[] hover = ComponentUtils.join(list, "\n");
        TextComponent groupComponent = new TextComponent(group.getName());
        groupComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/club" + group.getId()));
        groupComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover));
        return groupComponent;
    }

    public TextComponent getUserComponent(UserFull user) {
        if (user == null) {
            return ComponentUtils.getNullComponent();
        }
        String title = formatUser(user);
        BaseComponent[] hover;
        {
            String sex, city, status, birthday;
            switch (user.getSex()) {
                case MALE:
                    sex = Lang.MALE.toString();
                    break;
                case FEMALE:
                    sex = Lang.FEMALE.toString();
                    break;
                default:
                    sex = null;
                    break;
            }
            if (user.getCity() != null)
                city = user.getCity().getTitle();
            else
                city = null;
            if (user.getStatus() != null && user.getStatus().isEmpty())
                status = user.getStatus();
            else
                status = null;
            if (user.getBdate() != null && user.getBdate().isEmpty())
                birthday = user.getBdate();
            else
                birthday = null;
            List<String> list = Lang.USER_HOVER.toList();
            Map<String, String> replaceMap = new HashMap<>();
            replaceMap.put("{sex}", sex);
            replaceMap.put("{city}", city);
            replaceMap.put("{status}", status);
            replaceMap.put("{birthday}", birthday);
            ArrayUtils.replaceOrRemove(list, replaceMap);
            hover = ComponentUtils.join(list, "\n");
        }

        TextComponent component = new TextComponent(TextComponent.fromLegacyText(title));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover));
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/id" + user.getId()));
        return component;
    }


    public TextComponent getInviteLink(String url, String name) {
        String finalName = name == null ? "VK" : name;
        TextComponent conversationComponent = new TextComponent(ChatBuilder.compile(
                Lang.CONVERSATION_COMPONENT.toString(),
                new SimpleMapBuilder<String, BaseComponent[]>()
                        .add("{conversation}", TextComponent.fromLegacyText(finalName))
                        .getMap()
        ));
        conversationComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        conversationComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Lang.OPEN_URL_HOVER.toString("{conversation}", name))));
        return conversationComponent;
    }

    public boolean isConversation(int peerId) {
        return peerId >= 2000000000;
    }

    public BaseComponent[] buildMessage(int fromId, String text, BaseComponent[] prefixComponents) {
        String messageStructure = Lang.VK_TO_MINECRAFT_CHAT_FORMAT.toString();
        Map<String, BaseComponent[]> replaceMap = new HashMap<>();
        if (prefixComponents != null && prefixComponents.length > 0)
            replaceMap.put("{vk}", prefixComponents);
        else
            replaceMap.put("{vk}", new BaseComponent[]{new TextComponent()});
        replaceMap.put("{user}", new BaseComponent[]{getSenderComponent(fromId)});
        replaceMap.put("{text}", new BaseComponent[]{new TextComponent(text)});
        return ChatBuilder.compile(messageStructure, replaceMap);
    }

    public TextComponent getSenderComponent(Integer senderId) {
        if (isGroup(senderId))
            return getGroupComponent(senderId);
        else
            return getUserComponent(senderId);
    }

    public TextComponent getUserComponent(Integer user) {
        return getUserComponent(VkChat.getInstance().getCachedUserById(user));
    }

    public TextComponent getGroupComponent(Integer group) {
        return getGroupComponent(VkChat.getInstance().getCachedGroupById(group));
    }

    /**
     * Только в асинхронном
     */
    public List<ConversationModel> sendPlayerPeerMessage(PlayerModel pModel, String message) {
        List<ConversationModel> peers = DatabaseLoader.getBase().getPlayerMemberConversation(pModel.getUUID());
        for (ConversationModel model : peers) {
            int peerId = model.getId();
            VkChat.getInstance().sendMessage(peerId, message);
        }
        return peers;
    }

    public boolean isGroup(int id) {
        return id < 0;
    }

    public void scanMessageIds(Set<Integer> ids, ForeignMessage message) {
        ids.add(message.getFromId());
        if (message.getFwdMessages() != null)
            for (ForeignMessage fwdMessage : message.getFwdMessages()) {
                scanMessageIds(ids, fwdMessage);
            }
    }


    public String getPlayerToVk(AbstractPlayer sender) {
        PlayerModel link = DatabaseLoader.getBase().getPlayerByUUID(sender.getUUID());
        if (link != null) {
            return getPlayerToVk(link);
        } else {
            return sender.getName();
        }

    }

    public String getPlayerToVk(PlayerModel model) {
        if (VkChat.getInstance().isVkLinks())
            return String.format("[id%d|%s]", model.getVk(), model.getNickname());
        else
            return model.getNickname();
    }

    public String formatUser(UserFull user) {
        PlayerModel link = DatabaseLoader.getBase().getPlayerByVk(user.getId());
        if (link != null)
            return link.getNickname();
        else
            return Lang.USER_FORMAT.toString("{first_name}", user.getFirstName(), "{last_name}", user.getLastName());
    }

    public String prepareMessage(AbstractPlayer sender, String playerMessage) {
        return Lang.MINECRAFT_TO_VK_FORMAT
                .toString(
                        "{user}", VkUtils.getPlayerToVk(sender),
                        "{message}", playerMessage
                );
    }

    public TextComponent getInviteLink(ConversationModel model) {
        return getInviteLink(model.getInviteLink(), model.getTitle());
    }

    public void sendGlobal(String text) {
        ConversationModel peer = VkChat.getInstance().getGlobalConversation();
        if (peer != null)
            VkChat.getInstance().sendMessage(peer.getId(), text);
    }
    //TODO Как в апи добавят метод для выдачи админки
   /* public void checkOwner(Integer peerId, Integer fromId) {
        VkChat.getInstance().getLauncher().runTaskAsync(() -> {
            AbstractBase base = DatabaseLoader.getBase();
            ConversationModel model = base.getConversationById(peerId);
            if(model==null)
                return;
            PlayerModel player = base.getPlayerByVk(fromId);
            if(player==null)
                return;
            if(model.getOwner()==player.getUUID()){
                grantAdmin(peerId,fromId);
            }
        });
    }*/
}
