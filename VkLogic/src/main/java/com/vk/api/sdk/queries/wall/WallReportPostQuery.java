package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.WallReason;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.reportPost method
 */
public class WallReportPostQuery extends AbstractQueryBuilder<WallReportPostQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param postId value of "post id" parameter. Minimum is 0.
     */
    public WallReportPostQuery(VkApiClient client, UserActor actor, int ownerId, int postId) {
        super(client, "wall.reportPost", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        postId(postId);
    }

    /**
     * ID of the user or community that owns the wall.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallReportPostQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Post ID.
     *
     * @param value value of "post id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallReportPostQuery postId(int value) {
        return unsafeParam("post_id", value);
    }

    /**
     * Reason for the complaint: '0' – spam, '1' – child pornography, '2' – extremism, '3' – violence, '4' – drug propaganda, '5' – adult material, '6' – insult, abuse
     *
     * @param value value of "reason" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallReportPostQuery reason(WallReason value) {
        return unsafeParam("reason", value);
    }

    @Override
    protected WallReportPostQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("post_id", "owner_id", "access_token");
    }
}
