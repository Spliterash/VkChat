package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.setSilenceMode method
 */
public class AccountSetSilenceModeQuery extends AbstractQueryBuilder<AccountSetSilenceModeQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountSetSilenceModeQuery(VkApiClient client, UserActor actor) {
        super(client, "account.setSilenceMode", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Unique device ID.
     *
     * @param value value of "device id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetSilenceModeQuery deviceId(String value) {
        return unsafeParam("device_id", value);
    }

    /**
     * Time in seconds for what notifications should be disabled. '-1' to disable forever.
     *
     * @param value value of "time" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetSilenceModeQuery time(Integer value) {
        return unsafeParam("time", value);
    }

    /**
     * Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. "
     *
     * @param value value of "peer id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetSilenceModeQuery peerId(Integer value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * '1' — to enable sound in this dialog, '0' — to disable sound. Only if 'peer_id' contains user or community ID.
     *
     * @param value value of "sound" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetSilenceModeQuery sound(Integer value) {
        return unsafeParam("sound", value);
    }

    @Override
    protected AccountSetSilenceModeQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
