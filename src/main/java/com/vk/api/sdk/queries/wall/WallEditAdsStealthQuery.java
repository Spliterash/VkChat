package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.editAdsStealth method
 */
public class WallEditAdsStealthQuery extends AbstractQueryBuilder<WallEditAdsStealthQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param postId value of "post id" parameter. Minimum is 0.
     */
    public WallEditAdsStealthQuery(VkApiClient client, UserActor actor, int postId) {
        super(client, "wall.editAdsStealth", OkResponse.class);
        accessToken(actor.getAccessToken());
        postId(postId);
    }

    /**
     * User ID or community ID. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Post ID. Used for publishing of scheduled and suggested posts.
     *
     * @param value value of "post id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallEditAdsStealthQuery postId(int value) {
        return unsafeParam("post_id", value);
    }

    /**
     * (Required if 'attachments' is not set.) Text of the post.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * Only for posts in communities with 'from_group' set to '1': '1' — post will be signed with the name of the posting user, '0' — post will not be signed (default)
     *
     * @param value value of "signed" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery signed(Boolean value) {
        return unsafeParam("signed", value);
    }

    /**
     * Geographical latitude of a check-in, in degrees (from -90 to 90).
     *
     * @param value value of "lat" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery lat(Number value) {
        return unsafeParam("lat", value);
    }

    /**
     * Geographical longitude of a check-in, in degrees (from -180 to 180).
     *
     * @param value value of "long" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery lng(Number value) {
        return unsafeParam("long", value);
    }

    /**
     * ID of the location where the user was tagged.
     *
     * @param value value of "place id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery placeId(Integer value) {
        return unsafeParam("place_id", value);
    }

    /**
     * Link button ID
     *
     * @param value value of "link button" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery linkButton(String value) {
        return unsafeParam("link_button", value);
    }

    /**
     * Link title
     *
     * @param value value of "link title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery linkTitle(String value) {
        return unsafeParam("link_title", value);
    }

    /**
     * Link image url
     *
     * @param value value of "link image" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery linkImage(String value) {
        return unsafeParam("link_image", value);
    }

    /**
     * Link video ID in format "<owner_id>_<media_id>"
     *
     * @param value value of "link video" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery linkVideo(String value) {
        return unsafeParam("link_video", value);
    }

    /**
     * attachments
     * (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, 'page' — wiki-page, 'note' — note, 'poll' — poll, 'album' — photo album, '<owner_id>' — ID of the media application owner. '<media_id>' — Media application ID. Example: "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include in the post. Example: "photo66748_265827614,http://habrahabr.ru", "NOTE: If more than one link is being attached, an error will be thrown."
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    /**
     * (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, 'page' — wiki-page, 'note' — note, 'poll' — poll, 'album' — photo album, '<owner_id>' — ID of the media application owner. '<media_id>' — Media application ID. Example: "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include in the post. Example: "photo66748_265827614,http://habrahabr.ru", "NOTE: If more than one link is being attached, an error will be thrown."
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditAdsStealthQuery attachments(List<String> value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected WallEditAdsStealthQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("post_id", "access_token");
    }
}
