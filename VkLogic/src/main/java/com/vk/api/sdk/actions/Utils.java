package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.utils.UtilsCheckLinkQuery;
import com.vk.api.sdk.queries.utils.UtilsDeleteFromLastShortenedQuery;
import com.vk.api.sdk.queries.utils.UtilsGetLastShortenedLinksQuery;
import com.vk.api.sdk.queries.utils.UtilsGetLinkStatsQuery;
import com.vk.api.sdk.queries.utils.UtilsGetLinkStatsQueryWithExtended;
import com.vk.api.sdk.queries.utils.UtilsGetServerTimeQuery;
import com.vk.api.sdk.queries.utils.UtilsGetShortLinkQuery;
import com.vk.api.sdk.queries.utils.UtilsResolveScreenNameQuery;

/**
 * List of Utils methods
 */
public class Utils extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Utils(VkApiClient client) {
        super(client);
    }

    /**
     * Checks whether a link is blocked in VK.
     *
     * @param actor vk actor
     * @param url Link to check (e.g., 'http://google.com').
     * @return query
     */
    public UtilsCheckLinkQuery checkLink(UserActor actor, String url) {
        return new UtilsCheckLinkQuery(getClient(), actor, url);
    }

    /**
     * Checks whether a link is blocked in VK.
     *
     * @param actor vk actor
     * @param url Link to check (e.g., 'http://google.com').
     * @return query
     */
    public UtilsCheckLinkQuery checkLink(GroupActor actor, String url) {
        return new UtilsCheckLinkQuery(getClient(), actor, url);
    }

    /**
     * Checks whether a link is blocked in VK.
     *
     * @param actor vk actor
     * @param url Link to check (e.g., 'http://google.com').
     * @return query
     */
    public UtilsCheckLinkQuery checkLink(ServiceActor actor, String url) {
        return new UtilsCheckLinkQuery(getClient(), actor, url);
    }

    /**
     * Deletes shortened link from user's list.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsDeleteFromLastShortenedQuery deleteFromLastShortened(UserActor actor, String key) {
        return new UtilsDeleteFromLastShortenedQuery(getClient(), actor, key);
    }

    /**
     * Returns a list of user's shortened links.
     *
     * @param actor vk actor
     * @return query
     */
    public UtilsGetLastShortenedLinksQuery getLastShortenedLinks(UserActor actor) {
        return new UtilsGetLastShortenedLinksQuery(getClient(), actor);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQueryWithExtended getLinkStatsExtended(UserActor actor, String key) {
        return new UtilsGetLinkStatsQueryWithExtended(getClient(), actor, key);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQueryWithExtended getLinkStatsExtended(GroupActor actor, String key) {
        return new UtilsGetLinkStatsQueryWithExtended(getClient(), actor, key);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQueryWithExtended getLinkStatsExtended(ServiceActor actor, String key) {
        return new UtilsGetLinkStatsQueryWithExtended(getClient(), actor, key);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQuery getLinkStats(UserActor actor, String key) {
        return new UtilsGetLinkStatsQuery(getClient(), actor, key);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQuery getLinkStats(GroupActor actor, String key) {
        return new UtilsGetLinkStatsQuery(getClient(), actor, key);
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param actor vk actor
     * @param key Link key (characters after vk.cc/).
     * @return query
     */
    public UtilsGetLinkStatsQuery getLinkStats(ServiceActor actor, String key) {
        return new UtilsGetLinkStatsQuery(getClient(), actor, key);
    }

    /**
     * Returns the current time of the VK server.
     *
     * @param actor vk actor
     * @return query
     */
    public UtilsGetServerTimeQuery getServerTime(UserActor actor) {
        return new UtilsGetServerTimeQuery(getClient(), actor);
    }

    /**
     * Returns the current time of the VK server.
     *
     * @param actor vk actor
     * @return query
     */
    public UtilsGetServerTimeQuery getServerTime(GroupActor actor) {
        return new UtilsGetServerTimeQuery(getClient(), actor);
    }

    /**
     * Returns the current time of the VK server.
     *
     * @param actor vk actor
     * @return query
     */
    public UtilsGetServerTimeQuery getServerTime(ServiceActor actor) {
        return new UtilsGetServerTimeQuery(getClient(), actor);
    }

    /**
     * Allows to receive a link shortened via vk.cc.
     *
     * @param actor vk actor
     * @param url URL to be shortened.
     * @return query
     */
    public UtilsGetShortLinkQuery getShortLink(UserActor actor, String url) {
        return new UtilsGetShortLinkQuery(getClient(), actor, url);
    }

    /**
     * Allows to receive a link shortened via vk.cc.
     *
     * @param actor vk actor
     * @param url URL to be shortened.
     * @return query
     */
    public UtilsGetShortLinkQuery getShortLink(GroupActor actor, String url) {
        return new UtilsGetShortLinkQuery(getClient(), actor, url);
    }

    /**
     * Allows to receive a link shortened via vk.cc.
     *
     * @param actor vk actor
     * @param url URL to be shortened.
     * @return query
     */
    public UtilsGetShortLinkQuery getShortLink(ServiceActor actor, String url) {
        return new UtilsGetShortLinkQuery(getClient(), actor, url);
    }

    /**
     * Detects a type of object (e.g., user, community, application) and its ID by screen name.
     *
     * @param actor vk actor
     * @param screenName Screen name of the user, community (e.g., 'apiclub,' 'andrew', or 'rules_of_war'), or application.
     * @return query
     */
    public UtilsResolveScreenNameQuery resolveScreenName(UserActor actor, String screenName) {
        return new UtilsResolveScreenNameQuery(getClient(), actor, screenName);
    }

    /**
     * Detects a type of object (e.g., user, community, application) and its ID by screen name.
     *
     * @param actor vk actor
     * @param screenName Screen name of the user, community (e.g., 'apiclub,' 'andrew', or 'rules_of_war'), or application.
     * @return query
     */
    public UtilsResolveScreenNameQuery resolveScreenName(GroupActor actor, String screenName) {
        return new UtilsResolveScreenNameQuery(getClient(), actor, screenName);
    }

    /**
     * Detects a type of object (e.g., user, community, application) and its ID by screen name.
     *
     * @param actor vk actor
     * @param screenName Screen name of the user, community (e.g., 'apiclub,' 'andrew', or 'rules_of_war'), or application.
     * @return query
     */
    public UtilsResolveScreenNameQuery resolveScreenName(ServiceActor actor, String screenName) {
        return new UtilsResolveScreenNameQuery(getClient(), actor, screenName);
    }
}
