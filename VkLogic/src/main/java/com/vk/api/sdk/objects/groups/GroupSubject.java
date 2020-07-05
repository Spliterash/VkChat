package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupSubject implements EnumParam {
    @SerializedName("1")
    AUTO("1"),

    @SerializedName("2")
    ACTIVITY_HOLIDAYS("2"),

    @SerializedName("3")
    BUSINESS("3"),

    @SerializedName("4")
    PETS("4"),

    @SerializedName("5")
    HEALTH("5"),

    @SerializedName("6")
    DATING_AND_COMMUNICATION("6"),

    @SerializedName("7")
    GAMES("7"),

    @SerializedName("8")
    IT("8"),

    @SerializedName("9")
    CINEMA("9"),

    @SerializedName("10")
    BEAUTY_AND_FASHION("10"),

    @SerializedName("11")
    COOKING("11"),

    @SerializedName("12")
    ART_AND_CULTURE("12"),

    @SerializedName("13")
    LITERATURE("13"),

    @SerializedName("14")
    MOBILE_SERVICES_AND_INTERNET("14"),

    @SerializedName("15")
    MUSIC("15"),

    @SerializedName("16")
    SCIENCE_AND_TECHNOLOGY("16"),

    @SerializedName("17")
    REAL_ESTATE("17"),

    @SerializedName("18")
    NEWS_AND_MEDIA("18"),

    @SerializedName("19")
    SECURITY("19"),

    @SerializedName("20")
    EDUCATION("20"),

    @SerializedName("21")
    HOME_AND_RENOVATIONS("21"),

    @SerializedName("22")
    POLITICS("22"),

    @SerializedName("23")
    FOOD("23"),

    @SerializedName("24")
    INDUSTRY("24"),

    @SerializedName("25")
    TRAVEL("25"),

    @SerializedName("26")
    WORK("26"),

    @SerializedName("27")
    ENTERTAINMENT("27"),

    @SerializedName("28")
    RELIGION("28"),

    @SerializedName("29")
    FAMILY("29"),

    @SerializedName("30")
    SPORTS("30"),

    @SerializedName("31")
    INSURANCE("31"),

    @SerializedName("32")
    TELEVISION("32"),

    @SerializedName("33")
    GOODS_AND_SERVICES("33"),

    @SerializedName("34")
    HOBBIES("34"),

    @SerializedName("35")
    FINANCE("35"),

    @SerializedName("36")
    PHOTO("36"),

    @SerializedName("37")
    ESOTERICS("37"),

    @SerializedName("38")
    ELECTRONICS_AND_APPLIANCES("38"),

    @SerializedName("39")
    EROTIC("39"),

    @SerializedName("40")
    HUMOR("40"),

    @SerializedName("41")
    SOCIETY_HUMANITIES("41"),

    @SerializedName("42")
    DESIGN_AND_GRAPHICS("42");

    private final String value;

    GroupSubject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toLowerCase();
    }
}
