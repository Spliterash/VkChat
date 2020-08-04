package ru.spliterash.vkchat.objects;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.spliterash.vkchat.VkChat;

import java.util.Set;

//Because GSON set
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unused")
@Getter
public class ConversationInfo {
    @SerializedName("title")
    private String title;
    @SerializedName("members")
    private Set<Integer> members;

    public static ConversationInfo getInfo(int conversationId) throws ClientException, ApiException {
        VkApiClient executor = VkChat.getExecutor();
        JsonElement result = executor
                .execute()
                .code(VkChat.getInstance().getActor(),
                        "var peer = " + conversationId + ";\n" +
                                "var source = API.messages.getConversationMembers({\"peer_id\":peer})['items']@.member_id;\n" +
                                "var members = [];\n" +
                                "int i = 0;\n" +
                                "while(i<source.length){\n" +
                                "if (source[i]>0) {\n" +
                                "members.push(source[i]);\n" +
                                "}\n" +
                                "i = i + 1;\n" +
                                "}\n" +
                                "return \n" +
                                "{\n" +
                                "\"title\":API.messages.getConversationsById({\"peer_ids\":peer})['items'][0]['chat_settings']['title'],\n" +
                                "\"members\": members\n" +
                                "};"
                )
                .execute();
        return executor.getGson().fromJson(result, ConversationInfo.class);
    }
}
