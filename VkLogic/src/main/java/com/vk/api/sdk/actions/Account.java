package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.account.AccountBanQuery;
import com.vk.api.sdk.queries.account.AccountChangePasswordQuery;
import com.vk.api.sdk.queries.account.AccountGetActiveOffersQuery;
import com.vk.api.sdk.queries.account.AccountGetAppPermissionsQuery;
import com.vk.api.sdk.queries.account.AccountGetBannedQuery;
import com.vk.api.sdk.queries.account.AccountGetCountersQuery;
import com.vk.api.sdk.queries.account.AccountGetInfoQuery;
import com.vk.api.sdk.queries.account.AccountGetProfileInfoQuery;
import com.vk.api.sdk.queries.account.AccountGetPushSettingsQuery;
import com.vk.api.sdk.queries.account.AccountRegisterDeviceQuery;
import com.vk.api.sdk.queries.account.AccountSaveProfileInfoQuery;
import com.vk.api.sdk.queries.account.AccountSetInfoQuery;
import com.vk.api.sdk.queries.account.AccountSetNameInMenuQuery;
import com.vk.api.sdk.queries.account.AccountSetOfflineQuery;
import com.vk.api.sdk.queries.account.AccountSetOnlineQuery;
import com.vk.api.sdk.queries.account.AccountSetPushSettingsQuery;
import com.vk.api.sdk.queries.account.AccountSetSilenceModeQuery;
import com.vk.api.sdk.queries.account.AccountUnbanQuery;
import com.vk.api.sdk.queries.account.AccountUnregisterDeviceQuery;

/**
 * List of Account methods
 */
public class Account extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Account(VkApiClient client) {
        super(client);
    }

    /**
     * @param actor vk actor
     * @return query
     */
    public AccountBanQuery ban(UserActor actor) {
        return new AccountBanQuery(getClient(), actor);
    }

    /**
     * Changes a user password after access is successfully restored with the [vk.com/dev/auth.restore|auth.restore] method.
     *
     * @param actor vk actor
     * @param newPassword New password that will be set as a current
     * @return query
     */
    public AccountChangePasswordQuery changePassword(UserActor actor, String newPassword) {
        return new AccountChangePasswordQuery(getClient(), actor, newPassword);
    }

    /**
     * Returns a list of active ads (offers) which executed by the user will bring him/her respective number of votes to his balance in the application.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetActiveOffersQuery getActiveOffers(UserActor actor) {
        return new AccountGetActiveOffersQuery(getClient(), actor);
    }

    /**
     * Gets settings of the user in this application.
     *
     * @param actor vk actor
     * @param userId User ID whose settings information shall be got. By default: current user.
     * @return query
     */
    public AccountGetAppPermissionsQuery getAppPermissions(UserActor actor, int userId) {
        return new AccountGetAppPermissionsQuery(getClient(), actor, userId);
    }

    /**
     * Returns a user's blacklist.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetBannedQuery getBanned(UserActor actor) {
        return new AccountGetBannedQuery(getClient(), actor);
    }

    /**
     * Returns non-null values of user counters.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetCountersQuery getCounters(UserActor actor) {
        return new AccountGetCountersQuery(getClient(), actor);
    }

    /**
     * Returns current account info.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetInfoQuery getInfo(UserActor actor) {
        return new AccountGetInfoQuery(getClient(), actor);
    }

    /**
     * Returns the current account info.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetProfileInfoQuery getProfileInfo(UserActor actor) {
        return new AccountGetProfileInfoQuery(getClient(), actor);
    }

    /**
     * Gets settings of push notifications.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountGetPushSettingsQuery getPushSettings(UserActor actor) {
        return new AccountGetPushSettingsQuery(getClient(), actor);
    }

    /**
     * Subscribes an iOS/Android/Windows Phone-based device to receive push notifications
     *
     * @param actor vk actor
     * @param token Device token used to send notifications. (for mpns, the token shall be URL for sending of notifications)
     * @param deviceId Unique device ID.
     * @return query
     */
    public AccountRegisterDeviceQuery registerDevice(UserActor actor, String token,
            String deviceId) {
        return new AccountRegisterDeviceQuery(getClient(), actor, token, deviceId);
    }

    /**
     * Edits current profile info.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountSaveProfileInfoQuery saveProfileInfo(UserActor actor) {
        return new AccountSaveProfileInfoQuery(getClient(), actor);
    }

    /**
     * Allows to edit the current account info.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountSetInfoQuery setInfo(UserActor actor) {
        return new AccountSetInfoQuery(getClient(), actor);
    }

    /**
     * Sets an application screen name (up to 17 characters), that is shown to the user in the left menu.
     *
     * @param actor vk actor
     * @param userId User ID.
     * @return query
     */
    public AccountSetNameInMenuQuery setNameInMenu(UserActor actor, int userId) {
        return new AccountSetNameInMenuQuery(getClient(), actor, userId);
    }

    /**
     * Marks a current user as offline.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountSetOfflineQuery setOffline(UserActor actor) {
        return new AccountSetOfflineQuery(getClient(), actor);
    }

    /**
     * Marks the current user as online for 15 minutes.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountSetOnlineQuery setOnline(UserActor actor) {
        return new AccountSetOnlineQuery(getClient(), actor);
    }

    /**
     * Change push settings.
     *
     * @param actor vk actor
     * @param deviceId Unique device ID.
     * @return query
     */
    public AccountSetPushSettingsQuery setPushSettings(UserActor actor, String deviceId) {
        return new AccountSetPushSettingsQuery(getClient(), actor, deviceId);
    }

    /**
     * Mutes push notifications for the set period of time.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountSetSilenceModeQuery setSilenceMode(UserActor actor) {
        return new AccountSetSilenceModeQuery(getClient(), actor);
    }

    /**
     * @param actor vk actor
     * @return query
     */
    public AccountUnbanQuery unban(UserActor actor) {
        return new AccountUnbanQuery(getClient(), actor);
    }

    /**
     * Unsubscribes a device from push notifications.
     *
     * @param actor vk actor
     * @return query
     */
    public AccountUnregisterDeviceQuery unregisterDevice(UserActor actor) {
        return new AccountUnregisterDeviceQuery(getClient(), actor);
    }
}
