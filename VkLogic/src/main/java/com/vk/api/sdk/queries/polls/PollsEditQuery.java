package com.vk.api.sdk.queries.polls;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.PollsBackgroundId;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Polls.edit method
 */
public class PollsEditQuery extends AbstractQueryBuilder<PollsEditQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param pollId value of "poll id" parameter. Minimum is 0.
     */
    public PollsEditQuery(VkApiClient client, UserActor actor, int pollId) {
        super(client, "polls.edit", OkResponse.class);
        accessToken(actor.getAccessToken());
        pollId(pollId);
    }

    /**
     * Poll owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Edited poll's id
     *
     * @param value value of "poll id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PollsEditQuery pollId(int value) {
        return unsafeParam("poll_id", value);
    }

    /**
     * New question text
     *
     * @param value value of "question" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery question(String value) {
        return unsafeParam("question", value);
    }

    /**
     * Answers list, for example: , "["yes","no","maybe"]"
     *
     * @param value value of "add answers" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery addAnswers(String value) {
        return unsafeParam("add_answers", value);
    }

    /**
     * Object containing answers that need to be edited,, key – answer id, value – new answer text. Example: {"382967099":"option1", "382967103":"option2"}"
     *
     * @param value value of "edit answers" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery editAnswers(String value) {
        return unsafeParam("edit_answers", value);
    }

    /**
     * List of answer ids to be deleted. For example: "[382967099, 382967103]"
     *
     * @param value value of "delete answers" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery deleteAnswers(String value) {
        return unsafeParam("delete_answers", value);
    }

    /**
     * Set end date
     *
     * @param value value of "end date" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery endDate(Integer value) {
        return unsafeParam("end_date", value);
    }

    /**
     * Set photo id
     *
     * @param value value of "photo id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery photoId(Integer value) {
        return unsafeParam("photo_id", value);
    }

    /**
     * Set background id
     *
     * @param value value of "background id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PollsEditQuery backgroundId(PollsBackgroundId value) {
        return unsafeParam("background_id", value);
    }

    @Override
    protected PollsEditQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("poll_id", "access_token");
    }
}
