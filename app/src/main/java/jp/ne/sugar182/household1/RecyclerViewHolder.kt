package jp.ne.sugar182.household1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import jp.ne.sugar182.household1.dto.PayData
import jp.ne.sugar182.household1.dto.PayListData


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val payListData: PayListData = PayListData(view.findViewById(R.id.expenseDateText,
            view.findViewById(R.id.itemText),
    Integer.poerserInt(iew.findViewById(R.id.xpenseText))
    )
    val dateTextView: TextView = view.findViewById(R.id.expenseDateText)
    val itemTextView: TextView = view.findViewById(R.id.itemText)
    val payCurTextView: TextView = view.findViewById(R.id.xpenseText)


    init {
        // layoutの初期設定するときはココ
    }

}