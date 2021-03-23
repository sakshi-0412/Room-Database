package app.sakshi.userdeomo.mvp.main.presenter

import android.content.Context
import android.util.Log
import app.sakshi.userdeomo.mvp.main.model.list.resposne.ListResponse
import app.sakshi.userdeomo.mvp.main.view.GetListView
import app.sakshi.userdeomo.services.ApiClients
import app.sakshi.userdeomo.services.ApiInterface
import app.sakshi.userdeomo.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPresenter {
    lateinit var moListener: GetListView
    private var moApiClient: ApiClients? = null
    private var moContext: Context? = null

    constructor(foContext: Context, view: GetListView) {
        this.moListener = view
        this.moContext = foContext
        if (this.moApiClient == null) {
            this.moApiClient = ApiClients()
        }
    }

    fun getList(
        slug: String,
        parent_merchant_id: Int
    ) {
        val loApiInterface: ApiInterface = moApiClient!!.loAPICall
        val loCall: Call<ListResponse>? = loApiInterface.getList(
            Common.getHeaderMap(moContext!!),
            slug,
            parent_merchant_id
        )
        loCall!!.enqueue(object : Callback<ListResponse> {
            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                if (response.body() != null) {
                    moListener.onLisSuccess(response.body()!!)
                } else {
                    moListener.onLisFailure(response.message())
                }

                Log.i("ListPresenter", "Response: \t $response")
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                // Log error here since request failed
                moListener.onLisFailure(t.toString())
                Log.i("ListPresenter", t.toString())
            }
        })
    }
}