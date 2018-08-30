package jp.ne.sugar182.household1.model

import android.content.Context
import jp.ne.sugar182.household1.InnerStorage
import jp.ne.sugar182.household1.dto.WithdrawalData

// モデルとしてみたけど View（Activity）に情報を返すかは未定
// MVPモデルぽくなるのかな？
// ごりっとデータ操作を実装する。
abstract class WithdrawaModel {

    // null拒否で初期化不要な配列を作成するのに１時間悩む (ArrayList hoge = new ArrayList();のような。Javaでもコンストラクタ内でしか不可ですが)
    // Arrayでよいのかと思ったが空配列インスタンス生成は無理？
    // arrayListOfでJAVAのArrayListインスタンスを作成する模様 new ArrayListと同義。メソッド・コンストラクタ外で記述可能
    // たぶん実際はコンストラクタでnewされるんだろうね
    // TODO:Arrayについては再学習
    val fileName = "HouseholdData.dat"
    val withdrawds = arrayListOf<WithdrawalData>()
    var maxIdx: Int = 0;
    val innnerStorage : InnerStorage

    constructor(context: Context) {
        innnerStorage  = InnerStorage(fileName, context)
    }

    //view層が利用するfunを実装 TODO Interfaceで実装
    fun addData(withdrawalData: WithdrawalData) {
        withdrawds.add(withdrawalData)
    }

    fun remove(withdrawalData: WithdrawalData) {
        withdrawds.remove(withdrawalData)
    }

    fun createWithdrawalData(item: String, expense: Long, expenseDate: String): WithdrawalData {
        return WithdrawalData(getNewIndex(), expenseDate, item, expense)
    }

    // プライベートなfunを実装
    private fun getNewIndex(): Int {
        return maxIdx + 1
    }

    // ファイルをすべて読み込んでDataオブジェクトを作成していく
    private fun setData() {
        val datas: ArrayList<String> = innnerStorage.readFile()
        for (pair in datas){

        }
    }

    // KeyValue配列への変換
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

    abstract fun ArrayList(pair: Pair<String, String>): ArrayList<Pair<String, String>>


}