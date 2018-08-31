package jp.ne.sugar182.household1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.view.MenuItem

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        requestedOrientation = SCREEN_ORIENTATION_PORTRAIT

        // アクションバーに前画面に戻る機能をつける
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)


    }

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
}
