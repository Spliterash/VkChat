package com.vk.api.sdk.queries.board;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Board.addTopic method
 */
public class BoardAddTopicQuery extends AbstractQueryBuilder<BoardAddTopicQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     * @param title value of "title" parameter.
     */
    public BoardAddTopicQuery(VkApiClient client, UserActor actor, int groupId, String title) {
        super(client, "board.addTopic", Integer.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
        title(title);
    }

    /**
     * ID of the community that owns the discussion board.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected BoardAddTopicQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Topic title.
     *
     * @param value value of "title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected BoardAddTopicQuery title(String value) {
        return unsafeParam("title", value);
    }

    /**
     * Text of the topic.
     *
     * @param value value of "text" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardAddTopicQuery text(String value) {
        return unsafeParam("text", value);
    }

    /**
     * For a community: '1' — to post the topic as by the community, '0' — to post the topic as by the user (default)
     *
     * @param value value of "from group" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardAddTopicQuery fromGroup(Boolean value) {
        return unsafeParam("from_group", value);
    }

    /**
     * attachments
     * List of media objects attached to the topic, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media object: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media owner. '<media_id>' — Media ID. Example: "photo100172_166443618,photo66748_265827614", , "NOTE: If you try to attach more than one reference, an error will be thrown.",
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardAddTopicQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    /**
     * List of media objects attached to the topic, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media object: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media owner. '<media_id>' — Media ID. Example: "photo100172_166443618,photo66748_265827614", , "NOTE: If you try to attach more than one reference, an error will be thrown.",
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardAddTopicQuery attachments(List<String> value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected BoardAddTopicQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "title", "access_token");
    }
}
