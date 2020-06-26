package ru.spliterash.vkchat.utils;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.UserFull;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.chat.*;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public TextComponent getUserComponent(UserFull user) {
        String title = Lang.USER_FORMAT.toString()
                .replace("{first_name}", user.getFirstName())
                .replace("{last_name}", user.getLastName());
        ComponentBuilder hoverBuilder = new ComponentBuilder("");
        Lang.USER_HOVER.toList()
                .stream()
                .map(s -> {
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
                    return s
                            .replace("{sex}", sex)
                            .replace("{city}", city)
                            .replace("{status}", status)
                            .replace("{birthday}", birthday) + "\n";

                })
                .forEach(s -> hoverBuilder.append(TextComponent.fromLegacyText(s)));
        TextComponent component = new TextComponent(TextComponent.fromLegacyText(title));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverBuilder.create()));
        return component;
    }

    public BaseComponent[] getInviteLink() {
        ComponentBuilder builder = new ComponentBuilder("");
        builder.append(TextComponent.fromLegacyText(Lang.PEER_COMPONENT.toString()));
        builder.event(new ClickEvent(ClickEvent.Action.OPEN_URL, VkChat.getInstance().getPeerId()));
        builder.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Lang.OPEN_URL_HOVER.toString())));
        return builder.create();
    }

    public BaseComponent[] buildMessage(int fromId, String text, boolean peerLink) {
        String messageStructure = Lang.VK_TO_MINECRAFT.toString();
        Map<String, BaseComponent[]> replaceMap = new HashMap<>();
        if (peerLink)
            replaceMap.put("{vk}", getInviteLink());
        else
            replaceMap.put("{vk}", new BaseComponent[]{new TextComponent()});
        replaceMap.put("{user}", new BaseComponent[]{getUserComponent(fromId)});
        replaceMap.put("{text}", new BaseComponent[]{new TextComponent(text)});
        return ChatBuilder.compile(messageStructure, replaceMap);
    }

    private TextComponent getUserComponent(Integer user) {
        return getUserComponent(VkChat.getInstance().getUserById(user));
    }

    public void scanMessageIds(Set<Integer> ids, ForeignMessage message) {
        ids.add(message.getFromId());
        for (ForeignMessage fwdMessage : message.getFwdMessages()) {
            scanMessageIds(ids, fwdMessage);
        }
    }
}
