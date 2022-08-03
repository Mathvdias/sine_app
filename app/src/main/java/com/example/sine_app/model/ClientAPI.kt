package com.example.sine_app.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI() {

    companion object{


        private var retrofitInstance : Retrofit? = null

        // Inserir a url base aqui
        private val BASE_URL = "https://pokeapi.co/api/v2/"

        @JvmName("getRetrofitInstance1")
        private fun getRetrofitInstance() : Retrofit{
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            if(retrofitInstance == null){
                retrofitInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofitInstance!!
        }

        fun getService() : ServiceAPI{
            return  getRetrofitInstance().create(ServiceAPI::class.java)
        }
    }
}