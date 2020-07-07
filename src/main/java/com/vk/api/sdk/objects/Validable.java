package com.vk.api.sdk.objects;


import com.vk.api.sdk.exceptions.RequiredFieldException;
import com.vk.api.sdk.objects.annotations.Required;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface Validable {

    default boolean validateRequired() throws RequiredFieldException, NoSuchFieldException, IllegalAccessException {
        Field[] declaredFields = this.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            Annotation annotation = field.getAnnotation(Required.class);
            if (annotation != null) {
                Required required = (Required) annotation;
                if (required.value()) {
                    field.setAccessible(true);
                    if (field.get(this) == null) {
                        throw new RequiredFieldException(this.getClass().getName() + "." + field.getName());
                    }
                }
            }
        }

        return true;
    }
}
