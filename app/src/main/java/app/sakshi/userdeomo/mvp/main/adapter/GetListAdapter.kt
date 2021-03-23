package app.sakshi.userdeomo.mvp.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.sakshi.userdeomo.R
import app.sakshi.userdeomo.mvp.main.model.list.resposne.Data
import kotlinx.android.synthetic.main.list_transaction.view.*

class GetListAdapter(val foContext: Context? = null) :
    RecyclerView.Adapter<GetListAdapter.ViewHolder>() {
    private lateinit var moItems: ArrayList<Data>
    private var dataList = ArrayList<Data>()


    private val TAG = this.javaClass.simpleName
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val loView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_transaction, parent, false)
        return ViewHolder(loView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]

        with(holder) {
            kotlin.with(foContext) {
                Log.e(TAG, " onBindViewHolder: \t stName \t ${dataItem.account_head_id}")

                tvName.text = dataItem.merchant_name
                tvDate.text = dataItem.open_day_date
                tvLocation.text = dataItem.city


            }
        }
    }


    fun replaceItems(dataList: ArrayList<Data>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    class ViewHolder(foView: View) : RecyclerView.ViewHolder(foView) {
        var tvName: TextView = foView.tvName
        var tvDate: TextView = foView.tvDate
        var tvLocation: TextView = foView.tvLocation

    }

}