package com.vk.api.sdk.queries.likes;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.likes.Type;
import com.vk.api.sdk.objects.likes.responses.IsLikedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Likes.isLiked method
 */
public class LikesIsLikedQuery extends AbstractQueryBuilder<LikesIsLikedQuery, IsLikedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param type value of "type" parameter.
     * @param itemId value of "item id" parameter. Minimum is 0.
     */
    public LikesIsLikedQuery(VkApiClient client, UserActor actor, Type type, int itemId) {
        super(client, "likes.isLiked", IsLikedResponse.class);
        accessToken(actor.getAccessToken());
        type(type);
        itemId(itemId);
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LikesIsLikedQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion
     *
     * @param value value of "type" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected LikesIsLikedQuery type(Type value) {
        return unsafeParam("type", value);
    }

    /**
     * ID of the user or community that owns the object.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LikesIsLikedQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Object ID.
     *
     * @param value value of "item id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected LikesIsLikedQuery itemId(int value) {
        return unsafeParam("item_id", value);
    }

    @Override
    protected LikesIsLikedQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("item_id", "type", "access_token");
    }
}
