package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupMarketCurrency implements EnumParam {
    @SerializedName("643")
    RUSSIAN_RUBLES(643),

    @SerializedName("980")
    UKRAINIAN_HRYVNIA(980),

    @SerializedName("398")
    KAZAKH_TENGE(398),

    @SerializedName("978")
    EURO(978),

    @SerializedName("840")
    US_DOLLARS(840);

    private final Integer value;

    GroupMarketCurrency(Integer value) {
        this.value = value;
    }

    public String getValue() {
        return value.toString();
    }

    @Override
    public String toString() {
        return value.toString().toLowerCase();
    }
}
