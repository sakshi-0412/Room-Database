package app.sakshi.userdeomo.mvp.main.presenter

import android.content.Context
import android.util.Log
import app.sakshi.userdeomo.mvp.main.model.form.resposne.FormResponse
import app.sakshi.userdeomo.mvp.main.view.AddFormView
import app.sakshi.userdeomo.services.ApiClients
import app.sakshi.userdeomo.services.ApiInterface
import app.sakshi.userdeomo.utils.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFormPresenter {
    lateinit var moListener: AddFormView
    private var moApiClient: ApiClients? = null
    private var moContext: Context? = null

    constructor(foContext: Context, view: AddFormView) {
        this.moListener = view
        this.moContext = foContext
        if (this.moApiClient == null) {
            this.moApiClient = ApiClients()
        }
    }


    fun addForm(
        orderId: Int,
        slug: String,
        merchantId: Int,
        parent_merchant_id: Int,
        cash_receipt_amount: Int,
        receipt_date: String,
        status: String,
        ho_id: Int,
        payment_mode: Int,
        dr_account_head: Int,
        cr_account_head: Int,
        remark_maker: String,
        account_head_id: Int,
        dr_type: String,
        cr_type: String,
        invoice_file: String,
        remark: String
    ) {
        val loApiInterface: ApiInterface = moApiClient!!.loAPICall
        val loCall: Call<FormResponse>? = loApiInterface.addForm(Common.getHeaderMap(moContext!!),
        orderId,
        slug,
        merchantId,
        parent_merchant_id,
        cash_receipt_amount,
        receipt_date,
        status,
        ho_id,
        payment_mode,
        dr_account_head,
        cr_account_head,
        remark_maker,
        account_head_id,
        dr_type,
        cr_type,
        invoice_file,
        remark
        )
        loCall!!.enqueue(object : Callback<FormResponse> {
            override fun onResponse(call: Call<FormResponse>, response: Response<FormResponse>) {

                if (response.body() != null) {
                    moListener.onAddFormSuccess(response.body()!!)
                } else {
                    moListener.onAddFormFailure(response.message())
                }

                Log.i("AddFormPresenter", "Response: \t $response")
            }

            override fun onFailure(call: Call<FormResponse>, t: Throwable) {
                // Log error here since request failed
                moListener.onAddFormFailure(t.toString())
                Log.i("AddFormPresenter", t.toString())
            }
        })
    }
}