package jp.ne.sugar182.household1.dto

// TODO 1行で書けるので見直し
/*
class WithdrawalData {
    // プロパティ
    var idx: Int = 0        // index
    var item: String = ""   // 出費のアイテム
    var expense: Long = 0   // 金額
    var expenseDate: String = "" //日付

    // コンストラクタ
    constructor(idx: Int,item: String, expense: Long, expenseDate: String) {
        this.idx = idx
        this.item = item
        this.expense = expense
        this.expenseDate = expenseDate
    }

    fun getStringData(): String {
        return "$idx, $item, $expense, $expenseDate"
    }
}
*/
// 見直し後
data class WithdrawalData(val idx: Int, val expenseDate: String , val item: String, val xpense: Long )