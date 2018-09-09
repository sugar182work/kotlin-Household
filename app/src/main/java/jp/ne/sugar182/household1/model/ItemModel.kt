package jp.ne.sugar182.household1.model

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import jp.ne.sugar182.household1.R
import jp.ne.sugar182.household1.repository.SharedPreferencesUtil

class ItemModel(context: Context) {
    val context = context
    //アイテムリストのコントロールをするモデル層
    val spu = SharedPreferencesUtil("item_preferences", context)
    val keys = context.resources.getStringArray(R.array.keys).toMutableList()
    val items = mutableMapOf<String, String>()

    init {
        for (key in keys) {
            var ret = spu.get(key)
            Log.d("Shared$key", ret)
            items.put(key, ret)
            //reset()
        }
    }
    fun reset() {
        for (key in keys) {
            spu.save(key, "")
        }
    }
    fun addItem(item: String) {
        if (items.containsValue(item)) {
            Log.d("addItem","すでに登録すみ")
            return
        }
        for (key in keys) {
            if (items.get(key) == "") {
                items.put(key, item)
                spu.save(key, item)
                return
            }

        }
    }

    fun getAutCompleteList(): List<String> {
        return items.values.toList()
    }
}

