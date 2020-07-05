package com.vk.api.sdk.queries.widgets;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.widgets.responses.GetCommentsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Widgets.getComments method
 */
public class WidgetsGetCommentsQuery extends AbstractQueryBuilder<WidgetsGetCommentsQuery, GetCommentsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public WidgetsGetCommentsQuery(VkApiClient client, UserActor actor) {
        super(client, "widgets.getComments", GetCommentsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public WidgetsGetCommentsQuery(VkApiClient client, ServiceActor actor) {
        super(client, "widgets.getComments", GetCommentsResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
    }

    /**
     * Set widget api id
     *
     * @param value value of "widget api id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery widgetApiId(Integer value) {
        return unsafeParam("widget_api_id", value);
    }

    /**
     * Set url
     *
     * @param value value of "url" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery url(String value) {
        return unsafeParam("url", value);
    }

    /**
     * Set page id
     *
     * @param value value of "page id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery pageId(String value) {
        return unsafeParam("page_id", value);
    }

    /**
     * Set order
     *
     * @param value value of "order" parameter. By default date.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery order(String value) {
        return unsafeParam("order", value);
    }

    /**
     * Set offset
     *
     * @param value value of "offset" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Set count
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 10. By default 10.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WidgetsGetCommentsQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected WidgetsGetCommentsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
