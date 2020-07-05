package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.VideoSort;
import com.vk.api.sdk.objects.video.responses.SearchResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.search method
 */
public class VideoSearchQuery extends AbstractQueryBuilder<VideoSearchQuery, SearchResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param q value of "q" parameter.
     */
    public VideoSearchQuery(VkApiClient client, UserActor actor, String q) {
        super(client, "video.search", SearchResponse.class);
        accessToken(actor.getAccessToken());
        q(q);
    }

    /**
     * Search query string (e.g., 'The Beatles').
     *
     * @param value value of "q" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoSearchQuery q(String value) {
        return unsafeParam("q", value);
    }

    /**
     * Sort order: '1' — by duration, '2' — by relevance, '0' — by date added
     *
     * @param value value of "sort" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery sort(VideoSort value) {
        return unsafeParam("sort", value);
    }

    /**
     * If not null, only searches for high-definition videos.
     *
     * @param value value of "hd" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery hd(Integer value) {
        return unsafeParam("hd", value);
    }

    /**
     * '1' — to disable the Safe Search filter, '0' — to enable the Safe Search filter
     *
     * @param value value of "adult" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery adult(Boolean value) {
        return unsafeParam("adult", value);
    }

    /**
     * Set search own
     *
     * @param value value of "search own" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery searchOwn(Boolean value) {
        return unsafeParam("search_own", value);
    }

    /**
     * Offset needed to return a specific subset of videos.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Set longer
     *
     * @param value value of "longer" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery longer(Integer value) {
        return unsafeParam("longer", value);
    }

    /**
     * Set shorter
     *
     * @param value value of "shorter" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery shorter(Integer value) {
        return unsafeParam("shorter", value);
    }

    /**
     * Number of videos to return.
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Set extended
     *
     * @param value value of "extended" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * filters
     * Filters to apply: 'youtube' — return YouTube videos only, 'vimeo' — return Vimeo videos only, 'short' — return short videos only, 'long' — return long videos only
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery filters(String... value) {
        return unsafeParam("filters", value);
    }

    /**
     * Filters to apply: 'youtube' — return YouTube videos only, 'vimeo' — return Vimeo videos only, 'short' — return short videos only, 'long' — return long videos only
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoSearchQuery filters(List<String> value) {
        return unsafeParam("filters", value);
    }

    @Override
    protected VideoSearchQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("q", "access_token");
    }
}
