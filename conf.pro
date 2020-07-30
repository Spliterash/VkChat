-libraryjars 'C:\Program Files\Java\jre1.8.0_261\lib\rt.jar'
-printmapping 'VkChat.map'
-keepattributes *Annotation*,SourceFile, LineNumberTable
-dontnote
-dontwarn org.slf4j.**
-dontwarn javax.**
-dontwarn org.apache.**
# Для тестов
-dontobfuscate

-whyareyoukeeping class com.vk.api.sdk.objects.widgets.**


# Мои лаунчеры
-keep class ** extends ru.spliterash.vkchat.wrappers.Launcher {
    public <methods>;
}
# Не удалять мой код, но можно обфусцировать
-keepcode class ru.spliterash.vkchat.** {
    public <methods>;
}

# Не трогаем Gson
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
# Не трогаем енумный Gson ??
-keepclassmembers enum * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Сохраняем имена енумоф
-keepclassmembers enum  * {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Сериализацию да тоже надо
-keepclassmembers class * extends java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Нативные методы само собой
-keepclasseswithmembers,includedescriptorclasses,allowshrinking class * {
    native <methods>;
}
