package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.PhotosReason;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.reportComment method
 */
public class PhotosReportCommentQuery extends AbstractQueryBuilder<PhotosReportCommentQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param commentId value of "comment id" parameter. Minimum is 0.
     */
    public PhotosReportCommentQuery(VkApiClient client, UserActor actor, int ownerId,
            int commentId) {
        super(client, "photos.reportComment", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        commentId(commentId);
    }

    /**
     * ID of the user or community that owns the photo.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosReportCommentQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * ID of the comment being reported.
     *
     * @param value value of "comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosReportCommentQuery commentId(int value) {
        return unsafeParam("comment_id", value);
    }

    /**
     * Reason for the complaint: '0' – spam, '1' – child pornography, '2' – extremism, '3' – violence, '4' – drug propaganda, '5' – adult material, '6' – insult, abuse
     *
     * @param value value of "reason" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosReportCommentQuery reason(PhotosReason value) {
        return unsafeParam("reason", value);
    }

    @Override
    protected PhotosReportCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("owner_id", "comment_id", "access_token");
    }
}
