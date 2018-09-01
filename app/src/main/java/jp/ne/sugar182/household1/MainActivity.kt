package jp.ne.sugar182.household1

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Menu
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.DatePicker
import java.security.KeyStore
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        // ボタン押下で他画面起動
        val dateSelectButton = findViewById<Button>(R.id.buttonDateSelect);

        dateSelectButton.setOnClickListener {

            // std ::でclass.javaの参照を指定している？
            val intent = Intent(this, DateSelectActivity::class.java);
            startActivity(intent);
        }
        */

        //val filename: String = getString(R.string.file_name)

        //ボタン押下で情報登録
        val saveButton = findViewById<Button>(R.id.buttonSave);

        buttonSave.setOnClickListener {
            //innerStorage = InnerStorage()
            //innerStorage.saveFile(filename, getString(R.string.test), applicationContext)
        }
    }

    // TODO ここに実装するのはちょっと納得がいっていない　javaではごまかせた気がするので再検証
    override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int ) {
        val str = String.format(Locale.JAPAN, "%d/%d/%d", year, month+1, date)
        textViewDate.text = str;

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
