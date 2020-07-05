package com.vk.api.sdk.queries.users;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.UsersType;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Users.report method
 */
public class UsersReportQuery extends AbstractQueryBuilder<UsersReportQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param userId value of "user id" parameter. Minimum is 0.
     * @param type value of "type" parameter.
     */
    public UsersReportQuery(VkApiClient client, UserActor actor, int userId, UsersType type) {
        super(client, "users.report", OkResponse.class);
        accessToken(actor.getAccessToken());
        userId(userId);
        type(type);
    }

    /**
     * ID of the user about whom a complaint is being made.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected UsersReportQuery userId(int value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Type of complaint: 'porn' – pornography, 'spam' – spamming, 'insult' – abusive behavior, 'advertisement' – disruptive advertisements
     *
     * @param value value of "type" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected UsersReportQuery type(UsersType value) {
        return unsafeParam("type", value);
    }

    /**
     * Comment describing the complaint.
     *
     * @param value value of "comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public UsersReportQuery comment(String value) {
        return unsafeParam("comment", value);
    }

    @Override
    protected UsersReportQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("type", "user_id", "access_token");
    }
}
