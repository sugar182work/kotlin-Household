package jp.ne.sugar182.household1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val idxTextView: TextView = view.findViewById(R.id.idxText)
    val dateTextView: TextView = view.findViewById(R.id.dateText)
    val itemTextView: TextView = view.findViewById(R.id.itemText)
    val payTextView: TextView = view.findViewById(R.id.payText)
    val itemImageView: ImageView = view.findViewById(R.id.itemImageView)

    init {

    }

}
