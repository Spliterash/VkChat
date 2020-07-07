package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.pages.PagesClearCacheQuery;
import com.vk.api.sdk.queries.pages.PagesGetHistoryQuery;
import com.vk.api.sdk.queries.pages.PagesGetQuery;
import com.vk.api.sdk.queries.pages.PagesGetTitlesQuery;
import com.vk.api.sdk.queries.pages.PagesGetVersionQuery;
import com.vk.api.sdk.queries.pages.PagesParseWikiQuery;
import com.vk.api.sdk.queries.pages.PagesSaveAccessQuery;
import com.vk.api.sdk.queries.pages.PagesSaveQuery;

/**
 * List of Pages methods
 */
public class Pages extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Pages(VkApiClient client) {
        super(client);
    }

    /**
     * Allows to clear the cache of particular 'external' pages which may be attached to VK posts.
     *
     * @param actor vk actor
     * @param url Address of the page where you need to refesh the cached version
     * @return query
     */
    public PagesClearCacheQuery clearCache(UserActor actor, String url) {
        return new PagesClearCacheQuery(getClient(), actor, url);
    }

    /**
     * Allows to clear the cache of particular 'external' pages which may be attached to VK posts.
     *
     * @param actor vk actor
     * @param url Address of the page where you need to refesh the cached version
     * @return query
     */
    public PagesClearCacheQuery clearCache(ServiceActor actor, String url) {
        return new PagesClearCacheQuery(getClient(), actor, url);
    }

    /**
     * Returns information about a wiki page.
     *
     * @param actor vk actor
     * @return query
     */
    public PagesGetQuery get(UserActor actor) {
        return new PagesGetQuery(getClient(), actor);
    }

    /**
     * Returns a list of all previous versions of a wiki page.
     *
     * @param actor vk actor
     * @param pageId Wiki page ID.
     * @return query
     */
    public PagesGetHistoryQuery getHistory(UserActor actor, int pageId) {
        return new PagesGetHistoryQuery(getClient(), actor, pageId);
    }

    /**
     * Returns a list of wiki pages in a group.
     *
     * @param actor vk actor
     * @return query
     */
    public PagesGetTitlesQuery getTitles(UserActor actor) {
        return new PagesGetTitlesQuery(getClient(), actor);
    }

    /**
     * Returns the text of one of the previous versions of a wiki page.
     *
     * @param actor vk actor
     * @param versionId
     * @return query
     */
    public PagesGetVersionQuery getVersion(UserActor actor, int versionId) {
        return new PagesGetVersionQuery(getClient(), actor, versionId);
    }

    /**
     * Returns HTML representation of the wiki markup.
     *
     * @param actor vk actor
     * @param text Text of the wiki page.
     * @return query
     */
    public PagesParseWikiQuery parseWiki(UserActor actor, String text) {
        return new PagesParseWikiQuery(getClient(), actor, text);
    }

    /**
     * Saves the text of a wiki page.
     *
     * @param actor vk actor
     * @return query
     */
    public PagesSaveQuery save(UserActor actor) {
        return new PagesSaveQuery(getClient(), actor);
    }

    /**
     * Saves modified read and edit access settings for a wiki page.
     *
     * @param actor vk actor
     * @param pageId Wiki page ID.
     * @return query
     */
    public PagesSaveAccessQuery saveAccess(UserActor actor, int pageId) {
        return new PagesSaveAccessQuery(getClient(), actor, pageId);
    }
}
