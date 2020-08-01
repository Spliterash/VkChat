-libraryjars 'C:\Program Files\Java\jre1.8.0_261\lib\rt.jar'
-printmapping 'VkChat.map'
-keepattributes *Annotation*,SourceFile, LineNumberTable
#-dontnote
-dontwarn org.slf4j.**
-dontwarn javax.**
-dontwarn org.apache.**


-overloadaggressively
# Для тестов
#-dontobfuscate
# Когда буду тестить, обязательно надо раскоментировать
-addconfigurationdebugging
#-whyareyoukeeping class com.vk.api.sdk.exceptions.**
# Свалить всё в одну кучу
-repackageclasses ru.spliterash.vkchat

# Мои лаунчеры
-keep class ** extends ru.spliterash.vkchat.wrappers.Launcher {
    public <methods>;
}

# Не трогаем Gson
-keepclassmembernames class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
# Не трогаем мой код
 -keepclasseswithmembers,allowobfuscation class ru.spliterash.** {
    <methods>;
}
# Не трогаем енумный Gson ??
-keepclassmembernames enum * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Сохраняем имена енумоф
-keepclassmembernames enum  * {
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
