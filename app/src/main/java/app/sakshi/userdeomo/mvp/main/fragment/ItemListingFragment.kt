package app.sakshi.userdeomo.mvp.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.sakshi.userdeomo.R
import app.sakshi.userdeomo.databse.dao.DataDao
import app.sakshi.userdeomo.databse.model.DataEntity
import app.sakshi.userdeomo.databse.services.AppDatabase
import app.sakshi.userdeomo.mvp.main.adapter.GetListAdapter
import app.sakshi.userdeomo.mvp.main.model.list.resposne.Data
import app.sakshi.userdeomo.mvp.main.model.list.resposne.ListResponse
import app.sakshi.userdeomo.mvp.main.presenter.ListPresenter
import app.sakshi.userdeomo.mvp.main.view.GetListView
import app.sakshi.userdeomo.utils.Common
import org.jetbrains.anko.doAsync

class ItemListingFragment : Fragment(), GetListView {
    private val TAG = javaClass.simpleName
    private var moRootView: View? = null
    private lateinit var rvList: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var getListAdapter: GetListAdapter
    private lateinit var moItems: ArrayList<Data>
    private var listPresenter: ListPresenter? = null

    //Frpm DB
    private var moAppDatabase: AppDatabase? = null
    private var dataDao: DataDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moRootView = inflater.inflate(R.layout.fragment_item_listing, container, false)
        moAppDatabase = AppDatabase.getAppDataBase(this.context!!)
        dataDao = moAppDatabase!!.dataDao()
        listPresenter = ListPresenter(context!!, this)
        return moRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList = moRootView!!.findViewById(R.id.rvList)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvList.layoutManager = linearLayoutManager

        moItems = ArrayList()
        getListAdapter = GetListAdapter(context)
        rvList.adapter = getListAdapter
        getListAdapter.replaceItems(moItems)

        if (Common.isInternetAvailable(context)) {
            getTransactionList()
        } else {
            doAsync {
                getListFromDb()
            }

            getListAdapter.replaceItems(moItems)
            getListAdapter.notifyDataSetChanged()
        }

    }

    private fun getTransactionList() {
        listPresenter!!.getList("CrcptG", 1039)
    }


    private fun getListFromDb() {
        var getData: List<DataEntity> = ArrayList()
        getData = dataDao!!.getAllData()

        if (getData.size > 0) {
            for (liCount in 0 until getData.size) {
                val dataEntity: DataEntity = getData[liCount]
                val id = dataEntity.Id
                val merchantName = dataEntity.merchant_name
                val date = dataEntity.open_day_date
                val city = dataEntity.city

                val loCustomer: Data? = Data()
                loCustomer!!.id = Integer.parseInt(id)
                loCustomer.merchant_name = merchantName
                loCustomer.open_day_date = date
                loCustomer.city = city

                moItems.add(loCustomer)

            }
        }
    }

    override fun onLisSuccess(form: ListResponse) {
        Log.e(TAG, " onLisSuccess: \t form \t $form")
        Log.e(TAG, " onLisSuccess: \t form \t ${form.stStatus}")

        val error = form.stError
        if (error == 200) {

            Toast.makeText(context, "" + form.stMessage, Toast.LENGTH_LONG).show()

            for (liCount in 0 until form.stData!!.size) {
                val data: Data? = Data()

                Log.e(TAG, " onStatusSuccess: \t data \t $data")
                data!!.merchant_name = form.stData[liCount].merchant_name
                data.open_day_date = form.stData[liCount].open_day_date
                data.city = form.stData[liCount].city
                moItems.add(data)

            }

            getListAdapter.replaceItems(moItems)

        }
    }

    override fun onLisFailure(failureMsg: String?) {
        Log.e(TAG, " onLisFailure: \t failureMsg \t $failureMsg")
    }


}