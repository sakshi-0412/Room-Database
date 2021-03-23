package app.sakshi.userdeomo.databse.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataEntity(
    @PrimaryKey
    @ColumnInfo(name = "inUserId")
    val Id: String,

    @ColumnInfo(name = "open_day_date")
    val open_day_date: String,

    @ColumnInfo(name = "filter_merchant_id")
    val filter_merchant_id: String,

    @ColumnInfo(name = "user_id")
    val user_id: String,

    @ColumnInfo(name = "user_name")
    val user_name: String,

    @ColumnInfo(name = "payer_email")
    val payer_email: String,

    @ColumnInfo(name = "get_opening_balance")
    val get_opening_balance: String,

    @ColumnInfo(name = "filter_branch_id")
    val filter_branch_id: String,

    @ColumnInfo(name = "transaction_type_name")
    val transaction_type_name: String,

    @ColumnInfo(name = "display_net_balance")
    val display_net_balance: String,

    @ColumnInfo(name = "is_delete")
    val is_delete: String,

    @ColumnInfo(name = "is_edit")
    val is_edit: String,

    @ColumnInfo(name = "merchant_id")
    val merchant_id: String,

    @ColumnInfo(name = "merchant_branch_id")
    val merchant_branch_id: String,

    @ColumnInfo(name = "merchant_name")
    val merchant_name: String,

    @ColumnInfo(name = "sub_merchant_id")
    val sub_merchant_id: String,

    @ColumnInfo(name = "sub_branch_id")
    val sub_branch_id: String,

    @ColumnInfo(name = "sub_branch")
    val sub_branch: String,

    @ColumnInfo(name = "sub_branch_auto_sweep")
    val sub_branch_auto_sweep: String,

    @ColumnInfo(name = "amount")
    val amount: String,

    @ColumnInfo(name = "transfer_status")
    val transfer_status: String,

    @ColumnInfo(name = "invoice_file")
    val invoice_file: String,

    @ColumnInfo(name = "transaction_type")
    val transaction_type: String,

    @ColumnInfo(name = "transaction_type_slug")
    val transaction_type_slug: String,

    @ColumnInfo(name = "payment_mode")
    val payment_mode: String,

    @ColumnInfo(name = "payment_mode_name")
    val payment_mode_name: String,

    @ColumnInfo(name = "payment_modes_slug")
    val payment_modes_slug: String,

    @ColumnInfo(name = "payment_status")
    val payment_status: String,

    @ColumnInfo(name = "receipt_date")
    val receipt_date: String,

    @ColumnInfo(name = "state_id")
    val state_id: String,

    @ColumnInfo(name = "state")
    val state: String,

    @ColumnInfo(name = "city_id")
    val city_id: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "transaction_id")
    val transaction_id: String,

    @ColumnInfo(name = "transaction_status")
    val transaction_status: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "bill_book_balance")
    val bill_book_balance: String,

    @ColumnInfo(name = "month")
    val month: String,

    @ColumnInfo(name = "is_mm_received")
    val is_mm_received: String,

    @ColumnInfo(name = "receiver_merchant_id")
    val receiver_merchant_id: String,

    @ColumnInfo(name = "receiver_merchant_branch_id")
    val receiver_merchant_branch_id: String,

    @ColumnInfo(name = "receiver_merchant_name")
    val receiver_merchant_name: String,

    @ColumnInfo(name = "sender_merchant_id")
    val sender_merchant_id: String,

    @ColumnInfo(name = "sender_merchant_name")
    val sender_merchant_name: String,

    @ColumnInfo(name = "receiver_rahebar_id")
    val receiver_rahebar_id: String,

    @ColumnInfo(name = "receiver_rahebar_name")
    val receiver_rahebar_name: String,

    @ColumnInfo(name = "rahebar_id")
    val rahebar_id: String,

    @ColumnInfo(name = "rahebar_name")
    val rahebar_name: String,

    @ColumnInfo(name = "reason_receipt_id")
    val reason_receipt_id: String,

    @ColumnInfo(name = "reason_receipt_name")
    val reason_receipt_name: String,

    @ColumnInfo(name = "date_of_transfer")
    val date_of_transfer: String,

    @ColumnInfo(name = "deposit_date")
    val deposit_date: String,

    @ColumnInfo(name = "remark")
    val remark: String,

    @ColumnInfo(name = "remark_maker")
    val remark_maker: String,

    @ColumnInfo(name = "clarification_date")
    val clarification_date: String,

    @ColumnInfo(name = "remarks_date")
    val remarks_date: String,

    @ColumnInfo(name = "dr_account_head")
    val dr_account_head: String,

    @ColumnInfo(name = "dr_account_head_name")
    val dr_account_head_name: String,

    @ColumnInfo(name = "cr_account_head")
    val cr_account_head: String,

    @ColumnInfo(name = "cr_account_head_name")
    val cr_account_head_name: String,

    @ColumnInfo(name = "dr_type")
    val dr_type: String,

    @ColumnInfo(name = "cr_type")
    val cr_type: String,

    @ColumnInfo(name = "account_head_id")
    val account_head_id: String,

    @ColumnInfo(name = "account_head_name")
    val account_head_name: String,

    @ColumnInfo(name = "expense_date")
    val expense_date: String,

    @ColumnInfo(name = "reason_list_id")
    val reason_list_id: String,

    @ColumnInfo(name = "dop_slug")
    val dop_slug: String,

    @ColumnInfo(name = "reason_name")
    val reason_name: String,

    @ColumnInfo(name = "fiscal_year")
    val fiscal_year: String,

    @ColumnInfo(name = "slug")
    val slug: String,

    @ColumnInfo(name = "bank_id")
    val bank_id: String,

    @ColumnInfo(name = "bank_name")
    val bank_name: String,

    @ColumnInfo(name = "cashinout")
    val cashinout: String,

    @ColumnInfo(name = "closing")
    val closing: String,

    @ColumnInfo(name = "opening")
    val opening: String,

    @ColumnInfo(name = "date_order")
    val date_order: String,

    @ColumnInfo(name = "created_at")
    val created_at: String,

    @ColumnInfo(name = "Dr")
    val Dr: String,

    @ColumnInfo(name = "Cr")
    val Cr: String,

    @ColumnInfo(name = "is_autosweep")
    val is_autosweep: String,

    @ColumnInfo(name = "is_subautosweep")
    val is_subautosweep: String,

    @ColumnInfo(name = "menu_id")
    val menu_id: String,

    @ColumnInfo(name = "main_menu_id")
    val main_menu_id: String
)
