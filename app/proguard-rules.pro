# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Untuk mempertahankan suatu Class supaya tidak di-obfuscate
-dontwarn com.squareup.leakcanary.**
-dontwarn com.google.gson.**
-keep class net.sqlcipher** { *; }
-keep class net.sqlcipher.database** { *; }
-keep class kotlin.KotlinNullPointerException { *; }
-keep interface com.squareup.leakcanary** { *; }
-keep class com.squareup.leakcanary** { *; }
-keep class retrofit2** {*;}
-keep class kotlin** { *; }
-keep class kotlinx** { *; }
-keep class kotlin.Metadata { *; }
-keepclassmembers class com.kumastudio.capstoneproject** { *; }
-keep class androidx.appcompat.app.AppCompatActivity** { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}