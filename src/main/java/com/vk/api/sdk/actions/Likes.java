package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.likes.Type;
import com.vk.api.sdk.queries.likes.LikesAddQuery;
import com.vk.api.sdk.queries.likes.LikesDeleteQuery;
import com.vk.api.sdk.queries.likes.LikesGetListQuery;
import com.vk.api.sdk.queries.likes.LikesGetListQueryWithExtended;
import com.vk.api.sdk.queries.likes.LikesIsLikedQuery;

/**
 * List of Likes methods
 */
public class Likes extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Likes(VkApiClient client) {
        super(client);
    }

    /**
     * Adds the specified object to the 'Likes' list of the current user.
     *
     * @param actor vk actor
     * @param type Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @param itemId Object ID.
     * @return query
     */
    public LikesAddQuery add(UserActor actor, Type type, int itemId) {
        return new LikesAddQuery(getClient(), actor, type, itemId);
    }

    /**
     * Deletes the specified object from the 'Likes' list of the current user.
     *
     * @param actor vk actor
     * @param type Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @param itemId Object ID.
     * @return query
     */
    public LikesDeleteQuery delete(UserActor actor, Type type, int itemId) {
        return new LikesDeleteQuery(getClient(), actor, type, itemId);
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param actor vk actor
     * @param type , Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @return query
     */
    public LikesGetListQueryWithExtended getListExtended(UserActor actor, Type type) {
        return new LikesGetListQueryWithExtended(getClient(), actor, type);
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param actor vk actor
     * @param type , Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @return query
     */
    public LikesGetListQueryWithExtended getListExtended(ServiceActor actor, Type type) {
        return new LikesGetListQueryWithExtended(getClient(), actor, type);
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param actor vk actor
     * @param type , Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @return query
     */
    public LikesGetListQuery getList(UserActor actor, Type type) {
        return new LikesGetListQuery(getClient(), actor, type);
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param actor vk actor
     * @param type , Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion, 'sitepage' — page of the site where the [vk.com/dev/Like|Like widget] is installed
     * @return query
     */
    public LikesGetListQuery getList(ServiceActor actor, Type type) {
        return new LikesGetListQuery(getClient(), actor, type);
    }

    /**
     * Checks for the object in the 'Likes' list of the specified user.
     *
     * @param actor vk actor
     * @param type Object type: 'post' — post on user or community wall, 'comment' — comment on a wall post, 'photo' — photo, 'audio' — audio, 'video' — video, 'note' — note, 'photo_comment' — comment on the photo, 'video_comment' — comment on the video, 'topic_comment' — comment in the discussion
     * @param itemId Object ID.
     * @return query
     */
    public LikesIsLikedQuery isLiked(UserActor actor, Type type, int itemId) {
        return new LikesIsLikedQuery(getClient(), actor, type, itemId);
    }
}
