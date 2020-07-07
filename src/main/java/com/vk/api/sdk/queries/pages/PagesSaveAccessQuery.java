package com.vk.api.sdk.queries.pages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.PagesEdit;
import com.vk.api.sdk.objects.enums.PagesView;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Pages.saveAccess method
 */
public class PagesSaveAccessQuery extends AbstractQueryBuilder<PagesSaveAccessQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param pageId value of "page id" parameter.
     */
    public PagesSaveAccessQuery(VkApiClient client, UserActor actor, int pageId) {
        super(client, "pages.saveAccess", Integer.class);
        accessToken(actor.getAccessToken());
        pageId(pageId);
    }

    /**
     * Wiki page ID.
     *
     * @param value value of "page id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PagesSaveAccessQuery pageId(int value) {
        return unsafeParam("page_id", value);
    }

    /**
     * ID of the community that owns the wiki page.
     *
     * @param value value of "group id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PagesSaveAccessQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set user id
     *
     * @param value value of "user id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PagesSaveAccessQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Who can view the wiki page: '1' — only community members, '2' — all users can view the page, '0' — only community managers
     *
     * @param value value of "view" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PagesSaveAccessQuery view(PagesView value) {
        return unsafeParam("view", value);
    }

    /**
     * Who can edit the wiki page: '1' — only community members, '2' — all users can edit the page, '0' — only community managers
     *
     * @param value value of "edit" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PagesSaveAccessQuery edit(PagesEdit value) {
        return unsafeParam("edit", value);
    }

    @Override
    protected PagesSaveAccessQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token", "page_id");
    }
}
