package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * TokenPermissionSetting object
 */
public class TokenPermissionSetting implements Validable {
    @SerializedName("name")
    @Required
    private String name;

    @SerializedName("setting")
    @Required
    private Integer setting;

    public String getName() {
        return name;
    }

    public TokenPermissionSetting setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSetting() {
        return setting;
    }

    public TokenPermissionSetting setSetting(Integer setting) {
        this.setting = setting;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, setting);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenPermissionSetting tokenPermissionSetting = (TokenPermissionSetting) o;
        return Objects.equals(name, tokenPermissionSetting.name) &&
                Objects.equals(setting, tokenPermissionSetting.setting);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("TokenPermissionSetting{");
        sb.append("name='").append(name).append("'");
        sb.append(", setting=").append(setting);
        sb.append('}');
        return sb.toString();
    }
}
