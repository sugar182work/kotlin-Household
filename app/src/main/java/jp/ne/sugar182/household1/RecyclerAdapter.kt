package jp.ne.sugar182.household1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import jp.ne.sugar182.household1.dto.PayData

class RecyclerAdapter(private val context: Context,
                      private val itemClickListener: RecyclerViewHolder.ItemClickListener,
                      private val payList:List<PayData>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder?.let {
            it.itemTextView.text = payList.get(position).item
            it.dateTextView.text= payList.get(position).expenseDate
            it.xpenseTextView.text = payList.get(position).expense.toString()
        }
    }

    override fun getItemCount(): Int {
        return payList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }
}
