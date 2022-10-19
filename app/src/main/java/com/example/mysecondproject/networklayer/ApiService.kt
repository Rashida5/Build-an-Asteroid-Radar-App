package com.example.mysecondproject.networklayer

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import  com.example.mysecondproject.Constants
import com.example.mysecondproject.Constants.BASE_URL
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService{
    interface AsteroidService{
        @GET("neo/rest/v1/feed")
        suspend fun getAstroids(@Query("api_key") api_key:String)

        object Network{
            private val moshi=Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            private val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        }
    }
}