package com.vk.api.sdk.queries.pages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Pages.parseWiki method
 */
public class PagesParseWikiQuery extends AbstractQueryBuilder<PagesParseWikiQuery, String> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param text value of "text" parameter.
     */
    public PagesParseWikiQuery(VkApiClient client, UserActor actor, String text) {
        super(client, "pages.parseWiki", String.class);
        accessToken(actor.getAccessToken());
        text(text);
    }

    /**
     * Text of the wiki page.
     *
     * @param value value of "text" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PagesParseWikiQuery text(String value) {
        return unsafeParam("text", value);
    }

    /**
     * ID of the group in the context of which this markup is interpreted.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PagesParseWikiQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected PagesParseWikiQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("text", "access_token");
    }
}
