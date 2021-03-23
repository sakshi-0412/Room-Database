package app.sakshi.userdeomo.mvp.main.model.form.resposne

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FormResponse {

    @SerializedName("status")
    @Expose
    val stStatus: Boolean? = false

    @SerializedName("error")
    @Expose
    val stError: Int? = 0

    @SerializedName("message")
    @Expose
    val stMessage: String? = null

    @SerializedName("data")
    @Expose
    val stData: ArrayList<Data>? = null

}