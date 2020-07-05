package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.video.responses.AddAlbumResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.addAlbum method
 */
public class VideoAddAlbumQuery extends AbstractQueryBuilder<VideoAddAlbumQuery, AddAlbumResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public VideoAddAlbumQuery(VkApiClient client, UserActor actor) {
        super(client, "video.addAlbum", AddAlbumResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Community ID (if the album will be created in a community).
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoAddAlbumQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Album title.
     *
     * @param value value of "title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoAddAlbumQuery title(String value) {
        return unsafeParam("title", value);
    }

    /**
     * privacy
     * New access permissions for the album. Possible values: , *'0' – all users,, *'1' – friends only,, *'2' – friends and friends of friends,, *'3' – "only me".
     *
     * @param value value of "privacy" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoAddAlbumQuery privacy(String... value) {
        return unsafeParam("privacy", value);
    }

    /**
     * New access permissions for the album. Possible values: , *'0' – all users,, *'1' – friends only,, *'2' – friends and friends of friends,, *'3' – "only me".
     *
     * @param value value of "privacy" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoAddAlbumQuery privacy(List<String> value) {
        return unsafeParam("privacy", value);
    }

    @Override
    protected VideoAddAlbumQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
