package com.vk.api.sdk.queries.stories;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.stories.responses.GetByIdExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Stories.getById method
 */
public class StoriesGetByIdQueryWithExtended extends AbstractQueryBuilder<StoriesGetByIdQueryWithExtended, GetByIdExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQueryWithExtended(VkApiClient client, UserActor actor, String... stories) {
        super(client, "stories.getById", GetByIdExtendedResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQueryWithExtended(VkApiClient client, UserActor actor,
            List<String> stories) {
        super(client, "stories.getById", GetByIdExtendedResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQueryWithExtended(VkApiClient client, GroupActor actor,
            String... stories) {
        super(client, "stories.getById", GetByIdExtendedResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param stories value of "stories" parameter.
     */
    public StoriesGetByIdQueryWithExtended(VkApiClient client, GroupActor actor,
            List<String> stories) {
        super(client, "stories.getById", GetByIdExtendedResponse.class);
        accessToken(actor.getAccessToken());
        stories(stories);
        extended(true);
    }

    /**
     * '1' — to return additional fields for users and communities. Default value is 0.
     *
     * @param value value of "extended" parameter. By default false.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesGetByIdQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * stories
     * Stories IDs separated by commas. Use format {owner_id}+'_'+{story_id}, for example, 12345_54331.
     *
     * @param value value of "stories" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesGetByIdQueryWithExtended stories(String... value) {
        return unsafeParam("stories", value);
    }

    /**
     * Stories IDs separated by commas. Use format {owner_id}+'_'+{story_id}, for example, 12345_54331.
     *
     * @param value value of "stories" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesGetByIdQueryWithExtended stories(List<String> value) {
        return unsafeParam("stories", value);
    }

    /**
     * fields
     * Additional fields to return
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesGetByIdQueryWithExtended fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional fields to return
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesGetByIdQueryWithExtended fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected StoriesGetByIdQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("stories", "access_token");
    }
}
