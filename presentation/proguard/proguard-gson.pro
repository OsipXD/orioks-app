## GSON
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class ru.endlesscode.miet.orioks.entity.** { *; }
