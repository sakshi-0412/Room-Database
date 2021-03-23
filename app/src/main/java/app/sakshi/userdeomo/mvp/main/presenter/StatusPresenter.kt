package app.sakshi.userdeomo.mvp.main.presenter

import android.content.Context
import android.util.Log
import app.sakshi.userdeomo.mvp.main.model.status.resposne.StatusResponse
import app.sakshi.userdeomo.mvp.main.view.StatusView
import app.sakshi.userdeomo.services.ApiClients
import app.sakshi.userdeomo.services.ApiInterface
import app.sakshi.userdeomo.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatusPresenter {
    lateinit var moListener: StatusView
    private var moApiClient: ApiClients? = null
    private var moContext: Context? = null

    constructor(foContext: Context, view: StatusView) {
        this.moListener = view
        this.moContext = foContext
        if (this.moApiClient == null) {
            this.moApiClient = ApiClients()
        }
    }


    fun getStatus() {
        val loApiInterface: ApiInterface = moApiClient!!.loAPICall
        val loCall: Call<StatusResponse>? = loApiInterface.getStatus(Common.getHeaderMap(moContext!!))
        loCall!!.enqueue(object : Callback<StatusResponse> {
            override fun onResponse(call: Call<StatusResponse>, response: Response<StatusResponse>) {

                if (response.body() != null) {
                    moListener.onStatusSuccess(response.body()!!)
                } else {
                    moListener.onStatusFailure(response.message())
                }

                Log.i("StatusPresenter", "Response: \t $response")
            }

            override fun onFailure(call: Call<StatusResponse>, t: Throwable) {
                // Log error here since request failed
                moListener.onStatusFailure(t.toString())
                Log.i("StatusPresenter", t.toString())
            }
        })
    }
}