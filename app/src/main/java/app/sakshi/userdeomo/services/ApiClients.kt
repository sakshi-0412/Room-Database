package app.sakshi.userdeomo.services

import app.sakshi.userdeomo.utils.Common
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClients {
    fun client(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()

                .addInterceptor(interceptor)
                .connectTimeout(10000, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.HOURS)
                .writeTimeout(10, TimeUnit.HOURS)
                .build()
    }

    val loAPICall: ApiInterface
        get() {
            val retrofit = Retrofit.Builder()
                    .baseUrl(Common.BASE_URL)
                    .client(client())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }
}