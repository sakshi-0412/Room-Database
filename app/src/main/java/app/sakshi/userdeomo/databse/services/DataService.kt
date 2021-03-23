package app.sakshi.userdeomo.databse.services


import android.app.IntentService
import android.content.Intent
import app.sakshi.userdeomo.databse.dao.DataDao
import app.sakshi.userdeomo.databse.model.DataEntity
import app.sakshi.userdeomo.mvp.main.model.list.resposne.Data
import app.sakshi.userdeomo.mvp.main.model.list.resposne.ListResponse
import app.sakshi.userdeomo.mvp.main.presenter.ListPresenter
import app.sakshi.userdeomo.mvp.main.view.GetListView


class DataService : IntentService(DataService::class.java.name), GetListView {
    private val TAG = this.javaClass.simpleName
    var moAppDatabase: AppDatabase? = null
    var dataDao: DataDao? = null

    override fun onHandleIntent(foIntent: Intent?) {
        val loCustomerPresenter = ListPresenter(this, this)
        loCustomerPresenter.getList("CrcptG", 1039)
        moAppDatabase = AppDatabase.getAppDataBase(this)!!
        dataDao = moAppDatabase!!.dataDao()

    }


    companion object {
        var TAG = "PageList Intent Service"
    }

    override fun onLisSuccess(form: ListResponse) {
        if (form!!.stStatus == true) {
            for (liCount in 0 until form.stData!!.size) {
                val lsData: Data = form.stData[liCount]
                val lsMerchantName = lsData.merchant_name
                val date = lsData.open_day_date
                val city = lsData.city

                val loCustomer = DataEntity(
                    lsData.id.toString(),
                    date.toString(),
                    lsData.filter_merchant_id.toString(),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    lsMerchantName.toString(),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    city.toString(),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                )

                dataDao!!.addUser(loCustomer)
            }


        }
    }

    override fun onLisFailure(failureMsg: String?) {
    }

}



