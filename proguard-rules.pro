# プロガードの基本設定
#-----------------------------------

# デフォルトのProGuard設定ファイルをインクルード
-include proguard-android-optimize.txt

# アプリケーションのエントリーポイントを保持する
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.view.View
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.example.boatraceprediction.** { *; }

# ネイティブメソッドを保持する
-keepclasseswithmembernames class * {
    native <methods>;
}

# メインメソッドを保持する
-keepclasseswithmembers class * {
    public static void main(java.lang.String[]);
}

# シリアライズ可能なクラスを保持する
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    private void readObjectNoData();
}

# Androidの特定のクラスを保持する
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Gsonライブラリを使用する場合の設定
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.** { *; }
-keep class sun.misc.Unsafe { *; }

# Retrofitライブラリを使用する場合の設定
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }

# Jsoupライブラリを使用する場合の設定
-keep class org.jsoup.** { *; }

# TensorFlow Liteを使用する場合の設定
-keep class org.tensorflow.lite.** { *; }
-keepclassmembers class * {
    ** MODULE$;
}

# プロジェクト内の全クラスを保持する（例外的に使用する場合）
#-keep class com.example.boatraceprediction.** { *; }

# ログの設定を除去する（リリースビルド）
-assumenosideeffects if class android.util.Log {
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** d(...);
    public static *** e(...);
}

# 縮小と最適化のレポートを出力する
-printusage usage.txt
-printmapping mapping.txt
