-injars '..\build\libs\VkChat-3.0.jar'
-outjars 'VkChat-3.0.jar'

-libraryjars '<java.home>/lib/rt.jar'
-libraryjars '..\libs'

-printmapping 'VkChat.map'
-keepattributes *Annotation*
-dontnote
-dontwarn **



# OrmLite uses reflection
-keep class com.j256.**

-keepclassmembers class com.j256.** {
    <fields>;
    <methods>;
}

-keep enum  com.j256.**

-keepclassmembers enum  com.j256.** {
    <fields>;
    <methods>;
}

-keep interface  com.j256.**

-keepclassmembers interface  com.j256.** {
    <fields>;
    <methods>;
}
-keep class ** extends ru.spliterash.vkchat.wrappers.Launcher {
	public <methods>;
}

-keepcode class ru.spliterash.vkchat.** {
    public <methods>;
}

# Also keep - Enumerations. Keep the special static methods that are required in
# enumeration classes.
-keepclassmembers enum  * {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Also keep - Serialization code. Keep all fields and methods that are used for
# serialization.
-keepclassmembers class * extends java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep - Native method names. Keep all native class/method names.
-keepclasseswithmembers,includedescriptorclasses,allowshrinking class * {
    native <methods>;
}
