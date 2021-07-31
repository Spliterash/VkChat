package ru.spliterash.vkchat.utils;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.base.Image;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.MessageAttachment;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.PhotoSizes;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.video.Video;
import com.vk.api.sdk.objects.wall.WallpostFull;
import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.MatcherWrapper;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.chat.*;
import ru.spliterash.vkchat.objects.SimpleMapBuilder;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

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
            throw new RuntimeException("Token is not group token\n" + result);
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
        if (VkChat.getInstance().isVkLinks()) {
            component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover));
            component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://vk.com/id" + user.getId()));
        }
        return component;
    }


    public TextComponent getInviteLink(String url, String name) {
        String finalName = name == null ? "VK" : name;
        TextComponent conversationComponent = new TextComponent(ChatBuilder.replace(
                Lang.CONVERSATION_COMPONENT.toString(),
                new SimpleMapBuilder<String, BaseComponent[]>()
                        .add("{conversation}", TextComponent.fromLegacyText(finalName))
                        .getMap()
        ));
        conversationComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        conversationComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Lang.OPEN_CONVERSATION_HOVER.toString("{conversation}", name))));
        return conversationComponent;
    }

    public boolean isConversation(int peerId) {
        return peerId >= 2000000000;
    }


    public BaseComponent[] buildMessage(int fromId, String text, List<MessageAttachment> attachments, BaseComponent[] prefixComponents) {
        String messageStructure = Lang.VK_TO_MINECRAFT_CHAT_FORMAT.toString();
        Map<String, BaseComponent[]> replaceMap = new HashMap<>();
        if (prefixComponents != null && prefixComponents.length > 0)
            replaceMap.put("{vk}", prefixComponents);
        else
            replaceMap.put("{vk}", new BaseComponent[]{new TextComponent()});
        replaceMap.put("{user}", new BaseComponent[]{getSenderComponent(fromId)});
        replaceMap.put("{text}", replaceVkPlaceholders(text));
        replaceMap.put("{attachments}", getMessageAttachments(attachments));
        return ChatBuilder.replace(messageStructure, replaceMap);
    }

    private BaseComponent[] getMessageAttachments(List<MessageAttachment> attachmentList) {
        if (attachmentList == null || attachmentList.size() == 0)
            return new BaseComponent[0];
        String format = Lang.ATTACHMENT_FORMAT.toString();
        ComponentBuilder builder = new ComponentBuilder("");
        for (MessageAttachment attachment : attachmentList) {
            String componentName;
            String componentUrl;
            if (attachment.getType() == null) {
                componentName = Lang.UNSUPORTED_ATTACHMENT.toString();
                componentUrl = null;
            } else
                switch (attachment.getType()) {
                    case LINK:
                        componentName = attachment.getLink().getTitle();
                        componentUrl = attachment.getLink().getUrl().toExternalForm();
                        break;
                    case DOC:
                        componentName = attachment.getDoc().getTitle();
                        componentUrl = attachment.getDoc().getUrl().toExternalForm();
                        break;
                    case WALL:
                        WallpostFull post = attachment.getWall();
                        componentName = Lang.WALL_POST.toString();
                        componentUrl = "https://vk.com/wall" + post.getFromId() + "_" + post.getId();
                        break;
                    case AUDIO:
                        componentName = Lang.AUDIO_ATTACHMENT.toString();
                        componentUrl = attachment.getAudio().getUrl();
                        break;
                    case PHOTO:
                        componentName = Lang.PHOTO_ATTACHMENT.toString();
                        componentUrl = Optional
                                .ofNullable(ArrayUtils.getLastElement(attachment.getPhoto().getSizes()))
                                .map(PhotoSizes::getUrl)
                                .map(Object::toString)
                                .orElse(null);
                        break;
                    case STICKER:
                        componentName = Lang.STICKER_ATTACHMENT.toString();
                        componentUrl = Optional
                                .ofNullable(ArrayUtils.getLastElement(attachment.getSticker().getImages()))
                                .map(Image::getUrl)
                                .map(Object::toString)
                                .orElse(null);
                        break;
                    case VIDEO:
                        componentName = Lang.VIDEO_ATTACHMENT.toString();
                        Video video = attachment.getVideo();
                        componentUrl = "https://vk.com/video" + video.getOwnerId() + "_" + video.getId();
                        break;
                    case AUDIO_MESSAGE:
                        componentName = Lang.AUDIO_MESSAGE.toString();
                        componentUrl = attachment.getAudioMessage().getLinkMp3().toExternalForm();
                        break;
                    default:
                        componentName = Lang.UNSUPORTED_ATTACHMENT.toString();
                        componentUrl = null;
                }
            TextComponent attachmentComponent = new TextComponent(ChatBuilder.replace(
                    format, new SimpleMapBuilder<String, BaseComponent[]>()
                            .add("{name}", new BaseComponent[]{new TextComponent(componentName)})
                            .getMap()
            ));
            if (componentUrl != null && !componentUrl.isEmpty()) {
                attachmentComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, componentUrl));
                attachmentComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.OPEN_URL_HOVER.toComponent("{url}", componentUrl)));
            } else {
                attachmentComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.NO_URL.toComponent()));
            }
            builder.append(attachmentComponent, ComponentBuilder.FormatRetention.NONE);
        }
        return builder.create();
    }

    private String getPhotoUrl(Photo photo) {
        PhotoSizes last = ArrayUtils.getLastElement(photo.getSizes());
        if (last != null)
            return last.getUrl().toExternalForm();
        else
            return null;
    }

    private final Pattern vkLinkPattern = Pattern.compile("\\[(?<vkUrl>.*?)\\|(?<name>.*?)]|(?<fullUrl>(?:(https?)://)?(?<domain>[-\\w_.]{2,}\\.[a-z]{2,4})(/\\S*)?)");

    private BaseComponent[] replaceVkPlaceholders(String text) {
        return ChatBuilder.compile(text, VkUtils::processVkTokens, vkLinkPattern);
    }

    /**
     * Перерабатывает вкшный плейсхолдер в кликабельный майна
     *
     * @param matcher - Строка вида [id1234567|name] или же ссылка (https://vk.com, vk.com)
     */
    private BaseComponent[] processVkTokens(MatcherWrapper matcher) {
        String vkUrlName = matcher.group("name");
        String url, name;
        if (vkUrlName != null) {
            String urlEnd = matcher.group("vkUrl");
            url = "https://vk.com/" + urlEnd;
            name = vkUrlName;
        } else {
            name = matcher.group("domain");
            url = matcher.group("fullUrl");
        }
        TextComponent finalComponent = new TextComponent(ChatBuilder.replace(
                Lang.USER_LINK_FORMAT.toString(),
                new SimpleMapBuilder<String, BaseComponent[]>()
                        .add("{name}", new BaseComponent[]{new TextComponent(name)})
                        .getMap()
        ));
        finalComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.OPEN_URL_HOVER.toComponent("{url}", url)));
        finalComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        return new BaseComponent[]{finalComponent};
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
