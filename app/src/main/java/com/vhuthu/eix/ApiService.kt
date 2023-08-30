package com.vhuthu.eix

import com.vhuthu.eix.model.Todos
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header


data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val BASE_URL = "https://agrifund.tech/api/v2/"  // https://jsonplaceholder.typicode.com/

interface ApiService {

    @GET("farmers/portfolio")
    suspend fun getTodos(@Header("Authorization") token: String): List<Todos>

//    companion object {
//        var apiService: ApiService? = null
//        fun getInstance(): ApiService {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(ApiService::class.java)
//            }
//            return apiService!!
//        }
//    }


    companion object {
        private var apiService: ApiService? = null

        fun getInstance(token: String): ApiService {
            if (apiService == null) {
                val httpClient = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer $token")
                            .build()
                        chain.proceed(request)
                    }
                    .build()

                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }




}