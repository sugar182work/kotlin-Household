package jp.ne.sugar182.household1.dto


import android.util.Log
import com.google.gson.Gson
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

// GsonでのJSONとオブジェクトのマッピングはkotlin DataClassに使えなかった？TODO 使えるのか再度確認
// あまりサードパーティライブラリは好きではないがjackson使用
// もう一つ、KotlinDataオブジェクトのtoStringで取得した文字列から、Dataオブジェクトを逆生成するものもみつからなかった

//最初はTryで囲っていたが１行に変更してみた。可読性悪いな
class PayDataMapper {
    // デシリアライズ
    fun jsonToPayData(data :String): PayData =
            jacksonObjectMapper().readValue<PayData>(data)
    // シリアライズ
    fun payDataToJson(payData: PayData): String =
            jacksonObjectMapper().writeValueAsString(payData)
}