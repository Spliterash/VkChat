-injars '..\build\libs\VkChat-3.0.jar'
-outjars 'VkChat-3.0.jar'

-libraryjars '<java.home>\lib\rt.jar'
-libraryjars '..\libs'
-printmapping 'VkChat.map'
-keepattributes *Annotation*,SourceFile, LineNumberTable
#-dontnote
-dontwarn org.slf4j.**
-dontwarn javax.**
-dontwarn org.apache.**
# Для тестов
-dontobfuscate

-whyareyoukeeping class com.vk.api.sdk.objects.widgets.**


# OrmLite
-keepclassmembers @com.j256.ormlite.field.DatabaseField class ** {
	@com.j256.ormlite.field.DatabaseField <fields>;
	@com.j256.ormlite.field.ForeignCollectionField <fields>;
}
# Мои лаунчеры, так как в конфигах
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
