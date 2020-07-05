package com.vk.api.sdk.queries.stories;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.stories.responses.GetByIdResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Stories.getById method
 */
public class StoriesGetByIdQuery extends AbstractQueryBuilder<StoriesGetByIdQuery, GetByIdResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQuery(VkApiClient client, UserActor actor, String... stories) {
        super(client, "stories.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQuery(VkApiClient client, UserActor actor, List<String> stories) {
        super(client, "stories.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQuery(VkApiClient client, GroupActor actor, String... stories) {
        super(client, "stories.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQuery(VkApiClient client, GroupActor actor, List<String> stories) {
        super(client, "stories.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
    }

    /**
     * '1' — to return additional fields for users and communities. Default value is 0.
     *
     * @param value value of "extended" parameter. By default false.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesGetByIdQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * stories
     * Stories IDs separated by commas. Use format {owner_id}+'_'+{story_id}, for example, 12345_54331.
     *
     * @param value value of "stories" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesGetByIdQuery stories(String... value) {
        return unsafeParam("stories", value);
    }

    /**
     * Stories IDs separated by commas. Use format {owner_id}+'_'+{story_id}, for example, 12345_54331.
     *
     * @param value value of "stories" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesGetByIdQuery stories(List<String> value) {
        return unsafeParam("stories", value);
    }

    /**
     * fields
     * Additional fields to return
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesGetByIdQuery fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional fields to return
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesGetByIdQuery fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected StoriesGetByIdQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("stories", "access_token");
    }
}
