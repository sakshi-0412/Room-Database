package app.sakshi.userdeomo.mvp.main.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.sakshi.userdeomo.R
import app.sakshi.userdeomo.mvp.main.listener.OnItemClickListener
import app.sakshi.userdeomo.mvp.main.model.status.resposne.Data
import kotlinx.android.synthetic.main.list_status.view.*

class StatusAdapter(val foContext: Context? = null, val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<StatusAdapter.ViewHolder>() {
    private val TAG = this.javaClass.simpleName

    private var dataList = ArrayList<Data>()
    var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val loView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_status, parent, false)
        return ViewHolder(loView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]

        with(holder) {
            kotlin.with(foContext) {
                Log.e(TAG, " onBindViewHolder: \t stName \t ${dataItem.stName}")
                tvStatus.text = dataItem.stName

                if (selectedPosition == position) {
                    holder.itemView.setBackgroundColor(Color.parseColor("#3944BC"))
                    holder.tvStatus.setTextColor(Color.parseColor("#ffffff"))
                } else {
                    holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
                    holder.tvStatus.setTextColor(Color.parseColor("#3944BC"))
                }
                tvStatus.setOnClickListener {
                    onItemClickListener.onItemClick(position, dataItem.stName.toString())
                    selectedPosition = position;
                    notifyDataSetChanged();

                }

            }
        }
    }

    fun replaceItems(dataList: ArrayList<Data>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    class ViewHolder(foView: View) : RecyclerView.ViewHolder(foView) {
        var tvStatus: TextView = foView.tvStatus
    }
}