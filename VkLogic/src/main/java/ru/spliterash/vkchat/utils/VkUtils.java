package ru.spliterash.vkchat.utils;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.users.UserFull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.jetbrains.annotations.Nullable;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class VkUtils {
    public int getMyId(String token) throws ClientException, ApiException {
        GroupActor anonActor = new GroupActor(null, token);
        JsonObject result = VkChat
                .getExecutor()
                .execute()
                .code(anonActor,
                        "var l = API.photos.getMessagesUploadServer().upload_url;\n" +
                                "var i = l.indexOf(\"gid\");\n" +
                                "if (l.indexOf(\"gid=0\") == -1)\n" +
                                "{\n" +
                                "    return {\"type\":\"group\",\n" +
                                "            \"id\":parseInt(l.substr(i + 4, l.length - i + 4).split(\"&\")[0])};\n" +
                                "} else {\n" +
                                "    i = l.indexOf(\"mid\");\n" +
                                "    return {\"type\":\"user\",\n" +
                                "            \"id\":parseInt(l.substr(i + 4, l.length - i + 4).split(\"&\")[0])};\n" +
                                "}")
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
     * @return URL на беседу если ок, если ошибка вылетит exception
     */
    public ConversationCreateResponse createNewConversation() throws ClientException, ApiException {
        VkChat vk = VkChat.getInstance();
        VkApiClient executor = VkChat.getExecutor();
        //Костыль, потому что в SDK нет груп актора, уже сообщил в вк, а пока что так
        int id = executor
                .messages()
                .createChat(new UserActor(null, vk.getActor().getAccessToken()))
                .execute();
        String link = executor
                .messages()
                .getInviteLink(vk.getActor(), id)
                .execute()
                .getLink();
        return new ConversationCreateResponse(id,link);
    }

    @Getter
    @RequiredArgsConstructor
    public class ConversationCreateResponse {
        private final int id;
        private final String url;
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
        TextComponent linked = getLinkedUserComponent(user.getId());
        if (linked != null) {
            return linked;
        }
        String title = Lang.USER_FORMAT.toString(
                "{first_name}", user.getFirstName(),
                "{last_name}", user.getLastName()
        );
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
        ComponentBuilder builder = new ComponentBuilder("");
        builder.append(TextComponent.fromLegacyText(Lang.PEER_COMPONENT.toString()));
        builder.event(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Lang.OPEN_URL_HOVER.toString())));
        return builder.create();
    }

    public boolean isConversation(int peerId) {
        return peerId >= 2000000000;
    }

    public BaseComponent[] buildMessage(int fromId, String text, String peerLink) {
        String messageStructure = Lang.VK_TO_MINECRAFT.toString();
        Map<String, BaseComponent[]> replaceMap = new HashMap<>();
        if (peerLink != null)
            replaceMap.put("{vk}", getInviteLink(peerLink));
        else
            replaceMap.put("{vk}", new BaseComponent[]{new TextComponent()});
        replaceMap.put("{user}", new BaseComponent[]{getUserComponent(fromId)});
        replaceMap.put("{text}", new BaseComponent[]{new TextComponent(text)});
        return ChatBuilder.compile(messageStructure, replaceMap);
    }

    public TextComponent getUserComponent(Integer user) {
        return getUserComponent(VkChat.getInstance().getCachedUserById(user));
    }

    @Nullable
    public TextComponent getLinkedUserComponent(int id) {
        PlayerDao dao = Database.getInstance().getDao(PlayerModel.class);
        PlayerModel link = dao.queryForVk(id);
        if (link == null)
            return null;
        else
            return new TextComponent(link.getNickname());
    }

    public void scanMessageIds(Set<Integer> ids, ForeignMessage message) {
        ids.add(message.getFromId());
        for (ForeignMessage fwdMessage : message.getFwdMessages()) {
            scanMessageIds(ids, fwdMessage);
        }
    }
}
