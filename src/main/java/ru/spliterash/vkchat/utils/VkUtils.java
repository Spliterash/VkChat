package ru.spliterash.vkchat.utils;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.users.UserFull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.PlayerConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.chat.*;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

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
        //Костыль, потому что в SDK нет груп актора, уже сообщил в вк, а пока что так
        return executor
                .messages()
                .createChat(new UserActor(null, vk.getActor().getAccessToken()))
                .execute();

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

    public TextComponent getUserComponent(UserFull user) {
        if (user == null) {
            TextComponent component = new TextComponent(ChatColor.RED + "ERROR");
            component.setHoverEvent(
                    new HoverEvent(
                            HoverEvent.Action.SHOW_TEXT,
                            TextComponent.fromLegacyText(
                                    ChatColor.RED + "User not found, sry\nStacktrace here: \n" +
                                            Arrays
                                                    .stream(Thread.currentThread().getStackTrace())
                                                    .map(s -> s.getClassName() + " in method " + s.getMethodName() + " on line " + s.getLineNumber())
                                                    .collect(Collectors.joining("\n"))
                            )
                    ));
            return component;
        }
        String title = formatUser(user);
        ComponentBuilder hoverBuilder = new ComponentBuilder("");
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
                    sex = Lang.UNKNOWN.toString();
                    break;
            }
            if (user.getCity() != null)
                city = user.getCity().getTitle();
            else
                city = Lang.UNKNOWN.toString();
            if (user.getStatus() != null)
                status = user.getStatus();
            else
                status = Lang.UNKNOWN.toString();
            if (user.getBdate() != null)
                birthday = user.getBdate();
            else
                birthday = Lang.UNKNOWN.toString();
            List<String> list = Lang.USER_HOVER.toList(
                    "{sex}", sex,
                    "{city}", city,
                    "{status}", status,
                    "{birthday}", birthday
            );
            for (int i = 0; i < list.size(); i++) {
                String current = list.get(i);
                hoverBuilder.append(TextComponent.fromLegacyText(current), ComponentBuilder.FormatRetention.NONE);
                if (i < list.size() - 1) {
                    hoverBuilder.append("\n");
                }
            }
        }
        TextComponent component = new TextComponent(TextComponent.fromLegacyText(title));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverBuilder.create()));
        return component;
    }


    public BaseComponent[] getInviteLink(String url) {
        return getInviteLink(url, null);
    }

    public BaseComponent[] getInviteLink(String url, String name) {
        ComponentBuilder builder = new ComponentBuilder("");
        String componentText;
        if (name == null)
            componentText = Lang.CONVERSATION_COMPONENT.toString();
        else
            componentText = name;
        builder.append(TextComponent.fromLegacyText(componentText));
        builder.event(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Lang.OPEN_URL_HOVER.toString())));
        return builder.create();
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
        replaceMap.put("{user}", new BaseComponent[]{getUserComponent(fromId)});
        replaceMap.put("{text}", new BaseComponent[]{new TextComponent(text)});
        return ChatBuilder.compile(messageStructure, replaceMap);
    }

    public TextComponent getUserComponent(Integer user) {
        return getUserComponent(VkChat.getInstance().getCachedUserById(user));
    }

    public void sendToPlayers(int peerId, BaseComponent... components) {
        if (VkChat.getInstance().getGlobalPeer() == peerId) {

        }
    }

    /**
     * Только в асинхронном
     */
    public void sendPlayerPeerMessage(PlayerModel pModel, String message) throws SQLException {
        PlayerConversationDao pcd = Database.getDao(PlayerConversationModel.class);
        for (ConversationModel model : pcd.queryForPlayer(pModel)) {
            int peerId = model.getId();
            VkChat.getInstance().sendMessage(peerId, message);
        }
    }

    public void scanMessageIds(Set<Integer> ids, ForeignMessage message) {
        ids.add(message.getFromId());
        if (message.getFwdMessages() != null)
            for (ForeignMessage fwdMessage : message.getFwdMessages()) {
                scanMessageIds(ids, fwdMessage);
            }
    }

    @SneakyThrows
    public String getPlayerToVk(AbstractPlayer sender) {
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel link = dao.queryForId(sender.getUUID());
        if (link != null) {
            return getPlayerToVk(link);
        } else {
            return sender.getName();
        }

    }

    public String getPlayerToVk(PlayerModel model) {
        return "[" + model.getNickname() + "|id" + model.getVk() + "]";
    }

    public String getPlayerToVk(int userId) throws ClientException, ApiException {
        UserFull cached = VkChat.getInstance().getCachedUserById(userId, true);
        return getPlayerToVk(cached);
    }

    public String formatUser(UserFull user) {
        return Lang.USER_FORMAT.toString("{first_name}", user.getFirstName(), "{last_name}", user.getLastName());
    }

    private String getPlayerToVk(UserFull user) {
        PlayerDao pDao = Database.getDao(PlayerModel.class);
        PlayerModel link = pDao.queryForVk(user.getId());
        if (link != null) {
            return getPlayerToVk(link);
        } else {
            String format = formatUser(user);
            return "[" + format + "|id" + user.getId() + "]";
        }
    }

    public String prepareMessage(AbstractPlayer sender, String playerMessage) {
        return Lang.MINECRAFT_TO_VK_FORMAT
                .toString(
                        "{user}", VkUtils.getPlayerToVk(sender),
                        "{message}", playerMessage
                );
    }
}
