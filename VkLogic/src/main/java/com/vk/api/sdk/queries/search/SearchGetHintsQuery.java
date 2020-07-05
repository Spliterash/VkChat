package com.vk.api.sdk.queries.search;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.search.responses.GetHintsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Search.getHints method
 */
public class SearchGetHintsQuery extends AbstractQueryBuilder<SearchGetHintsQuery, GetHintsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public SearchGetHintsQuery(VkApiClient client, UserActor actor) {
        super(client, "search.getHints", GetHintsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Search query string.
     *
     * @param value value of "q" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery q(String value) {
        return unsafeParam("q", value);
    }

    /**
     * Offset for querying specific result subset
     *
     * @param value value of "offset" parameter. Maximum is 200. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Maximum number of results to return.
     *
     * @param value value of "limit" parameter. Maximum is 200. Minimum is 0. By default 9.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery limit(Integer value) {
        return unsafeParam("limit", value);
    }

    /**
     * Set search global
     *
     * @param value value of "search global" parameter. By default 1.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery searchGlobal(Boolean value) {
        return unsafeParam("search_global", value);
    }

    /**
     * filters
     * Set filters
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery filters(String... value) {
        return unsafeParam("filters", value);
    }

    /**
     * Set filters
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery filters(List<String> value) {
        return unsafeParam("filters", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery fields(String... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SearchGetHintsQuery fields(List<String> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected SearchGetHintsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
