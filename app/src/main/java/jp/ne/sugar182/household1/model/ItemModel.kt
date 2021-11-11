package jp.ne.sugar182.household1.model

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import jp.ne.sugar182.household1.R
import jp.ne.sugar182.household1.repository.SharedPreferencesUtil

class ItemModel(context: Context) {
    val context = context
    //アイテムリストのコントロールをするモデル層
    private val spu = SharedPreferencesUtil("item_preferences", context)
    private val keys = context.resources.getStringArray(R.array.keys).toMutableList()
    private val items = mutableMapOf<String, String?>()

    init {
        for (key in keys) {
            var ret = spu.get(key)
             items[key] = ret
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
            if (items[key] == "") {
                items[key] = item
                spu.save(key, item)
                return
            }

        }
    }

    fun getAutCompleteList(): List<String?> {
        return items.values.toList()
    }
}

