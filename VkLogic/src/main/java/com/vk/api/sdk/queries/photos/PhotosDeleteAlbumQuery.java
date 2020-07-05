package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.deleteAlbum method
 */
public class PhotosDeleteAlbumQuery extends AbstractQueryBuilder<PhotosDeleteAlbumQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param albumId value of "album id" parameter. Minimum is 0.
     */
    public PhotosDeleteAlbumQuery(VkApiClient client, UserActor actor, int albumId) {
        super(client, "photos.deleteAlbum", OkResponse.class);
        accessToken(actor.getAccessToken());
        albumId(albumId);
    }

    /**
     * Album ID.
     *
     * @param value value of "album id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosDeleteAlbumQuery albumId(int value) {
        return unsafeParam("album_id", value);
    }

    /**
     * ID of the community that owns the album.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosDeleteAlbumQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected PhotosDeleteAlbumQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("album_id", "access_token");
    }
}
