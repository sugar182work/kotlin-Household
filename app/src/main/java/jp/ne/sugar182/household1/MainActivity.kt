package jp.ne.sugar182.household1

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.DatePicker
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{

    var innerStorage: InnerStorage? = null


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

        val filename: String = getString(R.string.file_name)

        //ボタン押下で情報登録
        val saveButton = findViewById<Button>(R.id.buttonSave);

        buttonSave.setOnClickListener {
            innerStorage = InnerStorage()
            innerStorage!!.saveFile(filename, getString(R.string.test))
        }
    }

    /**
     * 起動時に日付をセットする。
     * */
    override fun onDateSet(view: DatePicker, year: Int, month: Int, date: Int ) {
        val str = String.format(Locale.JAPAN, "%d/%d/%d", year, month+1, date)
        textViewDate.text = str;

    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePick()
        newFragment.show(supportFragmentManager, "datePicker")

    }
}
