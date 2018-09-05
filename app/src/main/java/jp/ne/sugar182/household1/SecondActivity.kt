package jp.ne.sugar182.household1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        // アクションバーに前画面に戻る機能をつける
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        val hoges = resources.getStringArray(R.array.hoges).toMutableList()

        mainRecyclerView.adapter = RecyclerAdapter(this, this, hoges)
        mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

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

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}


