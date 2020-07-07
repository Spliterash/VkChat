package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.queries.secure.SecureAddAppEventQuery;
import com.vk.api.sdk.queries.secure.SecureCheckTokenQuery;
import com.vk.api.sdk.queries.secure.SecureGetAppBalanceQuery;
import com.vk.api.sdk.queries.secure.SecureGetSMSHistoryQuery;
import com.vk.api.sdk.queries.secure.SecureGetTransactionsHistoryQuery;
import com.vk.api.sdk.queries.secure.SecureGetUserLevelQuery;
import com.vk.api.sdk.queries.secure.SecureGiveEventStickerQuery;
import com.vk.api.sdk.queries.secure.SecureSendNotificationQuery;
import com.vk.api.sdk.queries.secure.SecureSendSMSNotificationQuery;
import com.vk.api.sdk.queries.secure.SecureSetCounterQuery;
import java.util.List;

/**
 * List of Secure methods
 */
public class Secure extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Secure(VkApiClient client) {
        super(client);
    }

    /**
     * Adds user activity information to an application
     *
     * @param actor vk actor
     * @param userId ID of a user to save the data
     * @param activityId there are 2 default activities: , * 1 – level. Works similar to ,, * 2 – points, saves points amount, Any other value is for saving completed missions
     * @return query
     */
    public SecureAddAppEventQuery addAppEvent(ServiceActor actor, int userId, int activityId) {
        return new SecureAddAppEventQuery(getClient(), actor, userId, activityId);
    }

    /**
     * Checks the user authentication in 'IFrame' and 'Flash' apps using the 'access_token' parameter.
     *
     * @param actor vk actor
     * @return query
     */
    public SecureCheckTokenQuery checkToken(ServiceActor actor) {
        return new SecureCheckTokenQuery(getClient(), actor);
    }

    /**
     * Returns payment balance of the application in hundredth of a vote.
     *
     * @param actor vk actor
     * @return query
     */
    public SecureGetAppBalanceQuery getAppBalance(ServiceActor actor) {
        return new SecureGetAppBalanceQuery(getClient(), actor);
    }

    /**
     * Shows a list of SMS notifications sent by the application using [vk.com/dev/secure.sendSMSNotification|secure.sendSMSNotification] method.
     *
     * @param actor vk actor
     * @return query
     */
    public SecureGetSMSHistoryQuery getSMSHistory(ServiceActor actor) {
        return new SecureGetSMSHistoryQuery(getClient(), actor);
    }

    /**
     * Shows history of votes transaction between users and the application.
     *
     * @param actor vk actor
     * @return query
     */
    public SecureGetTransactionsHistoryQuery getTransactionsHistory(ServiceActor actor) {
        return new SecureGetTransactionsHistoryQuery(getClient(), actor);
    }

    /**
     * Returns one of the previously set game levels of one or more users in the application.
     *
     * @param actor vk actor
     * @param userIds
     * @return query
     */
    public SecureGetUserLevelQuery getUserLevel(ServiceActor actor, Integer... userIds) {
        return new SecureGetUserLevelQuery(getClient(), actor, userIds);
    }

    /**
     * Returns one of the previously set game levels of one or more users in the application.
     *
     * @param actor vk actor
     * @param userIds
     * @return query
     */
    public SecureGetUserLevelQuery getUserLevel(ServiceActor actor, List<Integer> userIds) {
        return new SecureGetUserLevelQuery(getClient(), actor, userIds);
    }

    /**
     * Opens the game achievement and gives the user a sticker
     *
     * @param actor vk actor
     * @param achievementId
     * @param userIds
     * @return query
     */
    public SecureGiveEventStickerQuery giveEventSticker(ServiceActor actor, int achievementId,
            Integer... userIds) {
        return new SecureGiveEventStickerQuery(getClient(), actor, achievementId, userIds);
    }

    /**
     * Opens the game achievement and gives the user a sticker
     *
     * @param actor vk actor
     * @param achievementId
     * @param userIds
     * @return query
     */
    public SecureGiveEventStickerQuery giveEventSticker(ServiceActor actor, int achievementId,
            List<Integer> userIds) {
        return new SecureGiveEventStickerQuery(getClient(), actor, achievementId, userIds);
    }

    /**
     * Sends notification to the user.
     *
     * @param actor vk actor
     * @param message notification text which should be sent in 'UTF-8' encoding ('254' characters maximum).
     * @return query
     */
    public SecureSendNotificationQuery sendNotification(ServiceActor actor, String message) {
        return new SecureSendNotificationQuery(getClient(), actor, message);
    }

    /**
     * Sends 'SMS' notification to a user's mobile device.
     *
     * @param actor vk actor
     * @param userId ID of the user to whom SMS notification is sent. The user shall allow the application to send him/her notifications (, +1).
     * @param message 'SMS' text to be sent in 'UTF-8' encoding. Only Latin letters and numbers are allowed. Maximum size is '160' characters.
     * @return query
     */
    public SecureSendSMSNotificationQuery sendSMSNotification(ServiceActor actor, int userId,
            String message) {
        return new SecureSendSMSNotificationQuery(getClient(), actor, userId, message);
    }

    /**
     * Sets a counter which is shown to the user in bold in the left menu.
     *
     * @param actor vk actor
     * @return query
     */
    public SecureSetCounterQuery setCounter(ServiceActor actor) {
        return new SecureSetCounterQuery(getClient(), actor);
    }
}
