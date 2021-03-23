package app.sakshi.userdeomo.mvp.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import app.sakshi.userdeomo.R
import app.sakshi.userdeomo.databse.services.DataService
import app.sakshi.userdeomo.mvp.main.adapter.MyFragmentPagerAdapter
import app.sakshi.userdeomo.mvp.main.adapter.StatusAdapter
import app.sakshi.userdeomo.mvp.main.fragment.AddFormFragment
import app.sakshi.userdeomo.mvp.main.fragment.ItemListingFragment
import app.sakshi.userdeomo.mvp.main.listener.OnItemClickListener
import app.sakshi.userdeomo.mvp.main.model.status.resposne.Data
import app.sakshi.userdeomo.mvp.main.model.status.resposne.StatusResponse
import app.sakshi.userdeomo.mvp.main.presenter.StatusPresenter
import app.sakshi.userdeomo.utils.Common
import app.sakshi.userdeomo.utils.SharedPreferenceManager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), StatusView, OnItemClickListener {
    private val TAG = this.javaClass.simpleName

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var rvStatus: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var statusAdapter: StatusAdapter
    private lateinit var moItems: ArrayList<Data>
    private var statusPresenter: StatusPresenter? = null
    private var status = ""
    private lateinit var sharedPreferenceManager: SharedPreferenceManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferenceManager = SharedPreferenceManager(this)

        initViews()
        setupViewPager()

        if (Common.isInternetAvailable(this)) {
            getStatus()
        }
    }

    private fun initViews() {
        statusPresenter = StatusPresenter(this, this)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        rvStatus = findViewById(R.id.rvStatus)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvStatus.layoutManager = linearLayoutManager

        moItems = ArrayList()
        statusAdapter = StatusAdapter(this, this)
        rvStatus.adapter = statusAdapter
        statusAdapter.replaceItems(moItems)
    }

    private fun getStatus() {
        statusPresenter!!.getStatus()
    }


    override fun onResume() {
        super.onResume()

        val dataService = Intent(applicationContext, DataService::class.java)
        startService(dataService)

    }

    private fun setupViewPager() {

        val adapter = MyFragmentPagerAdapter(supportFragmentManager)

        var addFormFragment: AddFormFragment = AddFormFragment() //.newInstance("AddFormFragment")
        var itemListingFragment: ItemListingFragment = ItemListingFragment()

        adapter.addFragment(addFormFragment, "Add Form")
        adapter.addFragment(itemListingFragment, "Listing")

        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onStatusSuccess(status: StatusResponse) {
        Log.e(TAG, " onStatusSuccess: \t status \t $status")
        Log.e(TAG, " onStatusSuccess: \t status \t ${status.stStatus}")

        val error = status.stError
        if (error == 200) {
            Toast.makeText(this, "" + status.stMessage, Toast.LENGTH_LONG).show()

            for (liCount in 0 until status.stData!!.size) {
                val data: Data? = Data()

                Log.e(TAG, " onStatusSuccess: \t data \t $data")
                data!!.stUserId = status.stData[liCount].stUserId
                data.stHoId = status.stData[liCount].stHoId
                data.stId = status.stData[liCount].stId
                data.stName = status.stData[liCount].stName
                data.stSlug = status.stData[liCount].stSlug
                moItems.add(data)

            }

            statusAdapter.replaceItems(moItems)

        }

    }

    override fun onStatusFailure(failureMsg: String?) {
        Log.e(TAG, " onStatusFailure: \t failureMsg \t $failureMsg")
    }

    override fun onItemClick(position: Int, status: String) {
        Log.e(TAG, "position: $position")
        Log.e(TAG, "status: $status")

        this.status = status
        sharedPreferenceManager.status = status
    }
}