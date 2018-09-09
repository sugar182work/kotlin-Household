package jp.ne.sugar182.household1.dto


import android.util.Log
import com.google.gson.Gson
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

// GsonでのJSONとオブジェクトのマッピングはkotlin DataClassに使えなかった？TODO 使えるのか再度確認
// あまりサードパーティライブラリは好きではないがjackson使用
// もう一つDataオブジェクトのtoStringで取得した文字列から、Dataオブジェクトを生成するものもみつからなかった
class PayDataMapper {

    fun createPayData(data :String): PayData {
        val mapper = jacksonObjectMapper()

        try {
            val payData = mapper.readValue<PayData>(data)
            // 本当に中身が入っているのか
            Log.d("JsonSiriaraizeData", "payData:${payData.idx}:${payData.item}:${payData.payDate}:${payData.pay}")
            return payData

        } catch(e: Exception) {
            Log.d("Exception", e.stackTrace.toString())
        }
        return PayData()
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
}