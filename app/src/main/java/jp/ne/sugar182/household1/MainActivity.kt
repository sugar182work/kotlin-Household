package jp.ne.sugar182.household1

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Menu
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import jp.ne.sugar182.household1.dto.PayData
import jp.ne.sugar182.household1.model.ItemModel
import jp.ne.sugar182.household1.model.PayModel
import jp.ne.sugar182.household1.util.DateUtilEx

// コトリン学習１作目
// アーキテクチャーパターンとか採用せずにぐりぐりと実装　View層肥大しててすみません
// ・シェアードの読み書き
// ・内部ストレージの読み書き
// ・その他文法、癖の確認
class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 日付の初期値設定
        dateText.text = DateUtilEx().getNowString()

        // アイテムリストの処理
        val itemModel = ItemModel(this)

        //オートコンプリート関連
        val list = itemModel.getAutCompleteList()
        //val list = arrayOf("朝ごはん","昼ごはん","夜ごはん","交通費")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list)
        //アダプターのセット
        itemText.setAdapter(adapter)
        //最低行数のセット
        itemText.threshold = 1

        // データモデルを作成TODO ここじゃないかな
        val payModel = PayModel(this)


        //ボタン押下で情報登録
        //val saveButton = findViewById<Button>(R.id.saveButton);
        saveButton.setOnClickListener {
            val pay = if (payText.text.toString() == "") {
                0
            } else {
                payText.text.toString().toLong()
            }
            val payData = PayData(0, dateText.text.toString(), itemText.text.toString(), pay)


            if (checkData(payData)) {
                // シェアードに書き込み
                itemModel.addItem(payData.item)
                // Payデータに書き込み
                payModel.addData(payData)
            } else {
                checkError()
            }

        }

        // デバッグ用
        itemText.onItemClickListener = AdapterView.OnItemClickListener{
            parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()
            // Display the clicked item using toast
            Toast.makeText(applicationContext,"Selected : $selectedItem",Toast.LENGTH_SHORT).show()
        }


        itemText.setOnDismissListener {
            Toast.makeText(applicationContext,"Suggestion closed.",Toast.LENGTH_SHORT).show()
        }

        itemText.onFocusChangeListener = View.OnFocusChangeListener{
            view, b ->
            if(b){
                // Display the suggestion dropdown on focus
                itemText.showDropDown()
            }
        }

    }
    // エラーダイアログ　画面回転危険 TODOそのうち見直し
    private fun checkError() {
        AlertDialog.Builder(this)
                .setTitle("入力エラー")
                .setPositiveButton("ok"){ dialog, which ->
                }.show()
    }


    private fun checkData(payData: PayData) : Boolean {
        if (payData.pay <= 0) {
            Log.d("Long試験", "0以下")
        } else {
            Log.d("Long試験", "安心")
        }
        return !(payData.item == "" || payData.pay <= 0 || payData.payDate == "")
    }


    // TODO ここに実装するのはちょっと納得がいっていない　javaではごまかせた気がするので再検証
    override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int ) {
        val str = String.format(Locale.JAPAN, "%02d/%02d/%02d", year, month+1, date)
        dateText.text = str;

    }

    // カレンダーダイアログの表示
    fun showDatePickerDialog(v: View) {
        val newFragment = DatePick()
        newFragment.show(supportFragmentManager, "datePicker")

    }

    // メニューの追加
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        // 戻りの型の指定し忘れでGoogle先生に１時間質問する
        getMenuInflater().inflate(R.menu.option, menu);
        return true

    }

    // メニュー選択時のアクション
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // getMenuItem可ItemId直参照かで悩む　正解は不明
        when (item.itemId) {
            (R.id.summary) -> {
                // インテント作って別画面へ
                // 遷移先のActivityを指定して、Intentを作成する
                val intent = Intent(application, SecondActivity::class.java)
                // 遷移先のアクティビティを起動させる
                startActivity(intent)
            }
            (R.id.finish ) -> {
                finish()
            }
        }
        return true
    }
}
