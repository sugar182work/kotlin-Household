package jp.ne.sugar182.household1.dto

// 1行で書けるので見直し
/*
// SQLLite化も見越してindexをつけておく
class PayData(idx: Int,item: String, pay: Long, payDate: String) {
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
data class PayData(
        var idx: Int = 0,
        val payDate: String = "",
        val item: String = "",
        val pay: Long = 0
)