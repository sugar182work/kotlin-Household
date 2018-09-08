package jp.ne.sugar182.household1.dto


import android.util.Log
import com.google.gson.Gson
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.databind.ObjectMapper

// GronでのJSONとオブジェクトのマッピングはData型に使えなかった？使えるのか再度確認
// あまりサードパーティライブラリは好きではないがjackson使用
class PayDataMapper() {

    fun createPayData(data :String): PayData {
        val mapper = jacksonObjectMapper()
        val payData = mapper.readValue<PayData>(data)
        try {

        // 本当に中身が入っているのか
            Log.d("JsonSiriaraizeData", "payData:${payData.idx}:${payData.item}:${payData.payDate}:${payData.pay}")


        } catch(e: Exception) {
            Log.d("Exception", e.stackTrace.toString())
        }
        return payData
    }

    fun createJsonString(payData: PayData): String {
        val mapper = jacksonObjectMapper()
        try {
            val jsonString = mapper.writeValueAsString(payData)
            Log.d("JsonData", jsonString)
            return jsonString

        } catch(e: Exception) {
            Log.d("Exception", e.stackTrace.toString())
            return ""
        }
    }


    // KeyValue配列への変換 未使用
    // このPair型はコトリンのオリジナル。Pareって書いてGradel記述しようと思ったら先に認識されました。
    // "User(name=John, age=42)"って表示するtoString()
    private fun getKeyValue(data: String): ArrayList<Pair<String, String>> {
        // ここは文法理解のためにゴリっとアルゴリズム記述
        val i1 = data.indexOf("(")
        val i2 = data.indexOf(")",i1 + 1)
        val strArray = data.substring(i1 + 1, i2 -1).split(",")
        val ret: ArrayList<Pair<String, String>> = ArrayList()
        for (sa in strArray) {
            ret.add(Pair(sa.split("=")[0],sa.split("=")[1]))
        }
        return ret;

    }
}