package ru.spliterash.vkchat.vk;

import com.google.gson.JsonObject;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.VkChat;

@UtilityClass
public class VkUtils {
    public int getMyId(String token) throws ClientException, ApiException {
        GroupActor anonActor = new GroupActor(null,token);
        JsonObject result = VkChat
                .getClient()
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
}
