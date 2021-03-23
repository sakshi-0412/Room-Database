package app.sakshi.userdeomo.mvp.main.model.status.resposne

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("user_id")
    @Expose
    var stUserId: String? = null

    @SerializedName("ho_id")
    @Expose
    var stHoId: String? = null

    @SerializedName("id")
    @Expose
    var stId: String? = null

    @SerializedName("name")
    @Expose
    var stName: String? = null

    @SerializedName("slug")
    @Expose
    var stSlug: String? = null


}