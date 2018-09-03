package jp.ne.sugar182.household1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class SecondActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        requestedOrientation = SCREEN_ORIENTATION_PORTRAIT

        // アクションバーに前画面に戻る機能をつける
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        // リストビューの追加
        val listView = findViewById<ListView>(R.id.list_view)
        listView.setOnItemClickListener(this);
    }

    // 戻るボタンのリスナー
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // 戻るボタンを押下時の処理を記載
                // 今回は戻るだけ
                finish()
            }
            else -> {
                //
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // ListViewのタップのリスナー
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
