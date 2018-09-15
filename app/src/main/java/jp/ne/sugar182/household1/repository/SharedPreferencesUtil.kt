package jp.ne.sugar182.household1.repository

import android.content.Context
import android.util.Log

// シェアードプリファレンスアクセス
class SharedPreferencesUtil(fileName: String, context: Context) {
    val shardPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    //書き込み
    fun save(key: String, value: String) {
        val shardPrefEditor = shardPreferences.edit()
        shardPrefEditor.putString(key, value)
        shardPrefEditor.apply();
    }

    // 読み込み
    fun get(key: String): String {
        val value = shardPreferences.getString(key, "")
        Log.i("sharedvalue-$key" ,value)
        return value

    }
}