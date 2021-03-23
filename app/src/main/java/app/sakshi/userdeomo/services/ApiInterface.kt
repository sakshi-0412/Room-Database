package app.sakshi.userdeomo.services

import app.sakshi.userdeomo.mvp.main.model.form.resposne.FormResponse
import app.sakshi.userdeomo.mvp.main.model.list.resposne.ListResponse
import app.sakshi.userdeomo.mvp.main.model.status.resposne.StatusResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {


    @POST("get-payment-status")
    fun getStatus(
        @HeaderMap loHeaders: Map<String, String>
    ): Call<StatusResponse>?


    @POST("CrcptG")
    fun addForm(
        @HeaderMap loHeaders: Map<String, String>,
        @Query("order_id") order_id: Int,
        @Query("slug") slug: String,
        @Query("merchant_id") merchant_id: Int,
        @Query("parent_merchant_id") parent_merchant_id: Int,
        @Query("cash_receipt_amount") cash_receipt_amount: Int,
        @Query("receipt_date") receipt_date: String,
        @Query("status") status: String,
        @Query("ho_id") ho_id: Int,
        @Query("payment_mode") payment_mode: Int,
        @Query("dr_account_head") dr_account_head: Int,
        @Query("cr_account_head") cr_account_head: Int,
        @Query("remark_maker") remark_maker: String,
        @Query("account_head_id") account_head_id: Int,
        @Query("dr_type") dr_type: String,
        @Query("cr_type") cr_type: String,
        @Query("invoice_file") invoice_file: String,
        @Query("remark") remark: String
    ): Call<FormResponse>?


    @POST("get-transaction-listing")
    fun getList(
        @HeaderMap loHeaders: Map<String, String>,
        @Query("slug") slug: String,
        @Query("parent_merchant_id") parent_merchant_id: Int
    ): Call<ListResponse>?



}