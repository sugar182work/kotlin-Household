package jp.ne.sugar182.household1.dto

import java.util.*

// 1行で書けるので見直し
/*
class WithdrawalData(idx: Int,item: String, pay: Long, payDate: String) {
    // プロパティ
    var idx: Int = idx          // index
    var item: String = item     // 出費のアイテム
    var pay: Long = pay         // 金額
    var payDate: String = payDate //日付

    fun getStringData(): String {
        return "$idx, $item, $expense, $expenseDate"
    }
}
*/
// 見直し後　洗練されたロンボクさんですなぁ
data class PayData(val idx: Int, val payDatre: String , val item: String, val payCurrency: Long )