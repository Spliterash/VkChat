-libraryjars 'C:\Program Files\Java\jre1.8.0_301\lib\rt.jar'
-printmapping 'VkChat.map'
-keepattributes *Annotation*,SourceFile,LineNumberTable,Signature
#-dontnote
-dontwarn org.slf4j.**
-dontwarn javax.**
-dontwarn org.apache.**
-dontwarn **

-optimizationpasses 5
-overloadaggressively
# Для тестов
-dontobfuscate
# Когда буду тестить, обязательно надо раскоментировать
#-addconfigurationdebugging
-whyareyoukeeping class org.jsoup.nodes.Document
# Свалить всё в одну кучу
-repackageclasses ru.spliterash.vkchat
-allowaccessmodification
-dontnote

# Мои лаунчеры
-keep class * extends ru.spliterash.vkchat.wrappers.Launcher
# Сохраняем всё моё, разрешая запутывание
-keepclassmembers,allowobfuscation class ru.spliterash.** { *; }
-keep class com.vk.api.sdk.httpclient.** { *; }

-keep class sun.misc.Unsafe { *; }

# Сохраняем имена енумоф
-keepclassmembernames enum  * {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
# Ещё раз на всякий случай
-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Сериализацию да тоже надо
-keepclassmembernames class * extends java.io.Serializable {
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


# Правила для GSON
# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep,allowobfuscation class * extends com.google.gson.TypeAdapter
-keep,allowobfuscation class * implements com.google.gson.TypeAdapterFactory
-keep,allowobfuscation class * implements com.google.gson.JsonSerializer
-keep,allowobfuscation class * implements com.google.gson.JsonDeserializer

# Надо переделать так, чтобы удаляло неюзаемые переменные
# Методы то удаляет
-keepclassmembers,allowshrinking,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}