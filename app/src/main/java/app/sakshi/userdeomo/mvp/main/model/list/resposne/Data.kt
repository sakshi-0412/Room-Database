package app.sakshi.userdeomo.mvp.main.model.list.resposne

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Data {


    @SerializedName("open_day_date")
    @Expose
    var open_day_date: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("filter_merchant_id")
    @Expose
    val filter_merchant_id: Int? = null

    @SerializedName("user_id")
    @Expose
    val user_id: Int? = null

    @SerializedName("user_name")
    @Expose
    val user_name: String? = null

    @SerializedName("payer_email")
    @Expose
    val payer_email: String? = null

    @SerializedName("get_opening_balance")
    @Expose
    val get_opening_balance: Int? = null

    @SerializedName("filter_branch_id")
    @Expose
    val filter_branch_id: String? = null

    @SerializedName("transaction_type_name")
    @Expose
    val transaction_type_name: String? = null

    @SerializedName("display_net_balance")
    @Expose
    val display_net_balance: Int? = null

    @SerializedName("is_delete")
    @Expose
    val is_delete: Int? = null

    @SerializedName("is_edit")
    @Expose
    val is_edit: Int? = null

    @SerializedName("merchant_id")
    @Expose
    val merchant_id: Int? = null

    @SerializedName("merchant_branch_id")
    @Expose
    val merchant_branch_id: String? = null

    @SerializedName("merchant_name")
    @Expose
    var merchant_name: String? = null

    @SerializedName("sub_merchant_id")
    @Expose
    val sub_merchant_id: Int? = null

    @SerializedName("sub_branch_id")
    @Expose
    val sub_branch_id: Int? = null

    @SerializedName("sub_branch")
    @Expose
    val sub_branch: String? = null

    @SerializedName("sub_branch_auto_sweep")
    @Expose
    val sub_branch_auto_sweep: Int? = null

    @SerializedName("amount")
    @Expose
    val amount: Int? = null

    @SerializedName("transfer_status")
    @Expose
    val transfer_status: String? = null

    @SerializedName("invoice_file")
    @Expose
    val invoice_file: String? = null

    @SerializedName("transaction_type")
    @Expose
    val transaction_type: Int? = null

    @SerializedName("transaction_type_slug")
    @Expose
    val transaction_type_slug: String? = null

    @SerializedName("payment_mode")
    @Expose
    val payment_mode: Int? = null

    @SerializedName("payment_mode_name")
    @Expose
    val payment_mode_name: String? = null

    @SerializedName("payment_modes_slug")
    @Expose
    val payment_modes_slug: String? = null

    @SerializedName("payment_status")
    @Expose
    val payment_status: String? = null

    @SerializedName("receipt_date")
    @Expose
    val receipt_date: String? = null

    @SerializedName("state_id")
    @Expose
    val state_id: Int? = null

    @SerializedName("state")
    @Expose
    val state: String? = null

    @SerializedName("city_id")
    @Expose
    val city_id: Int? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("transaction_id")
    @Expose
    val transaction_id: String? = null

    @SerializedName("transaction_status")
    @Expose
    val transaction_status: String? = null

    @SerializedName("date")
    @Expose
    val date: String? = null

    @SerializedName("bill_book_balance")
    @Expose
    val bill_book_balance: Int? = null

    @SerializedName("month")
    @Expose
    val month: String? = null

    @SerializedName("is_mm_received")
    @Expose
    val is_mm_received: Int? = null

    @SerializedName("receiver_merchant_id")
    @Expose
    val receiver_merchant_id: Int? = null

    @SerializedName("receiver_merchant_branch_id")
    @Expose
    val receiver_merchant_branch_id: Int? = null

    @SerializedName("receiver_merchant_name")
    @Expose
    val receiver_merchant_name: String? = null

    @SerializedName("sender_merchant_id")
    @Expose
    val sender_merchant_id: Int? = null

    @SerializedName("sender_merchant_name")
    @Expose
    val sender_merchant_name: String? = null

    @SerializedName("receiver_rahebar_id")
    @Expose
    val receiver_rahebar_id: Int? = null

    @SerializedName("receiver_rahebar_name")
    @Expose
    val receiver_rahebar_name: String? = null

    @SerializedName("rahebar_id")
    @Expose
    val rahebar_id: Int? = null

    @SerializedName("rahebar_name")
    @Expose
    val rahebar_name: String? = null

    @SerializedName("reason_receipt_id")
    @Expose
    val reason_receipt_id: Int? = null

    @SerializedName("reason_receipt_name")
    @Expose
    val reason_receipt_name: String? = null

    @SerializedName("date_of_transfer")
    @Expose
    val date_of_transfer: String? = null

    @SerializedName("deposit_date")
    @Expose
    val deposit_date: String? = null

    @SerializedName("remark")
    @Expose
    val remark: String? = null

    @SerializedName("remark_maker")
    @Expose
    val remark_maker: String? = null

    @SerializedName("clarification_date")
    @Expose
    val clarification_date: String? = null

    @SerializedName("remarks_date")
    @Expose
    val remarks_date: String? = null

    @SerializedName("dr_account_head")
    @Expose
    val dr_account_head: Int? = null

    @SerializedName("dr_account_head_name")
    @Expose
    val dr_account_head_name: Boolean? = null

    @SerializedName("cr_account_head")
    @Expose
    val cr_account_head: Int? = null

    @SerializedName("cr_account_head_name")
    @Expose
    val cr_account_head_name: Boolean? = null

    @SerializedName("dr_type")
    @Expose
    val dr_type: String? = null

    @SerializedName("cr_type")
    @Expose
    val cr_type: String? = null

    @SerializedName("account_head_id")
    @Expose
    val account_head_id: Int? = null

    @SerializedName("account_head_name")
    @Expose
    val account_head_name: String? = null

    @SerializedName("expense_date")
    @Expose
    val expense_date: String? = null

    @SerializedName("reason_list_id")
    @Expose
    val reason_list_id: Int? = null

    @SerializedName("dop_slug")
    @Expose
    val dop_slug: String? = null

    @SerializedName("reason_name")
    @Expose
    val reason_name: String? = null

    @SerializedName("fiscal_year")
    @Expose
    val fiscal_year: String? = null

    @SerializedName("slug")
    @Expose
    val slug: String? = null

    @SerializedName("bank_id")
    @Expose
    val bank_id: Int? = null

    @SerializedName("bank_name")
    @Expose
    val bank_name: String? = null

    @SerializedName("cashinout")
    @Expose
    val cashinout: String? = null

    @SerializedName("closing")
    @Expose
    val closing: Int? = null

    @SerializedName("opening")
    @Expose
    val opening: Int? = null

    @SerializedName("date_order")
    @Expose
    val date_order: String? = null

    @SerializedName("created_at")
    @Expose
    val created_at: String? = null

    @SerializedName("Dr")
    @Expose
    val dr: String? = null

    @SerializedName("Cr")
    @Expose
    val cr: Int? = null

    @SerializedName("is_autosweep")
    @Expose
    val is_autosweep: Int? = null

    @SerializedName("is_subautosweep")
    @Expose
    val is_subautosweep: Int? = null

    @SerializedName("menu_id")
    @Expose
    val menu_id: Int? = null

    @SerializedName("main_menu_id")
    @Expose
    val main_menu_id: Int? = null
}