package app.sakshi.userdeomo.mvp.main.model.form.resposne

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("order_id")
    @Expose
    var stOrderId: String? = null

    @SerializedName("date_order")
    @Expose
    var stDateOrder: String? = null

    @SerializedName("amount")
    @Expose
    var stAmount: String? = null

    @SerializedName("merchant_id")
    @Expose
    var stMerchantId: String? = null

    @SerializedName("cash_balance")
    @Expose
    var stCashBalance: String? = null
}