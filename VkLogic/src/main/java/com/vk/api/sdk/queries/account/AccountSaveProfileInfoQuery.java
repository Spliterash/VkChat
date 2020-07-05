package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.account.responses.SaveProfileInfoResponse;
import com.vk.api.sdk.objects.enums.AccountBdateVisibility;
import com.vk.api.sdk.objects.enums.AccountRelation;
import com.vk.api.sdk.objects.enums.AccountSex;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.saveProfileInfo method
 */
public class AccountSaveProfileInfoQuery extends AbstractQueryBuilder<AccountSaveProfileInfoQuery, SaveProfileInfoResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountSaveProfileInfoQuery(VkApiClient client, UserActor actor) {
        super(client, "account.saveProfileInfo", SaveProfileInfoResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * User first name.
     *
     * @param value value of "first name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery firstName(String value) {
        return unsafeParam("first_name", value);
    }

    /**
     * User last name.
     *
     * @param value value of "last name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery lastName(String value) {
        return unsafeParam("last_name", value);
    }

    /**
     * User maiden name (female only)
     *
     * @param value value of "maiden name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery maidenName(String value) {
        return unsafeParam("maiden_name", value);
    }

    /**
     * User screen name.
     *
     * @param value value of "screen name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery screenName(String value) {
        return unsafeParam("screen_name", value);
    }

    /**
     * ID of the name change request to be canceled. If this parameter is sent, all the others are ignored.
     *
     * @param value value of "cancel request id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery cancelRequestId(Integer value) {
        return unsafeParam("cancel_request_id", value);
    }

    /**
     * User sex. Possible values: , * '1' – female,, * '2' – male.
     *
     * @param value value of "sex" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery sex(AccountSex value) {
        return unsafeParam("sex", value);
    }

    /**
     * User relationship status. Possible values: , * '1' – single,, * '2' – in a relationship,, * '3' – engaged,, * '4' – married,, * '5' – it's complicated,, * '6' – actively searching,, * '7' – in love,, * '0' – not specified.
     *
     * @param value value of "relation" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery relation(AccountRelation value) {
        return unsafeParam("relation", value);
    }

    /**
     * ID of the relationship partner.
     *
     * @param value value of "relation partner id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery relationPartnerId(Integer value) {
        return unsafeParam("relation_partner_id", value);
    }

    /**
     * User birth date, format: DD.MM.YYYY.
     *
     * @param value value of "bdate" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery bdate(String value) {
        return unsafeParam("bdate", value);
    }

    /**
     * Birth date visibility. Returned values: , * '1' – show birth date,, * '2' – show only month and day,, * '0' – hide birth date.
     *
     * @param value value of "bdate visibility" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery bdateVisibility(AccountBdateVisibility value) {
        return unsafeParam("bdate_visibility", value);
    }

    /**
     * User home town.
     *
     * @param value value of "home town" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery homeTown(String value) {
        return unsafeParam("home_town", value);
    }

    /**
     * User country.
     *
     * @param value value of "country id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery countryId(Integer value) {
        return unsafeParam("country_id", value);
    }

    /**
     * User city.
     *
     * @param value value of "city id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery cityId(Integer value) {
        return unsafeParam("city_id", value);
    }

    /**
     * Status text.
     *
     * @param value value of "status" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSaveProfileInfoQuery status(String value) {
        return unsafeParam("status", value);
    }

    @Override
    protected AccountSaveProfileInfoQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
