package com.example.breakingbad.network

import com.example.breakingbad.model.Character
import com.example.breakingbad.model.Death
import com.example.breakingbad.model.Episode
import com.example.breakingbad.model.Quote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//base url api
private const val BASE_URL = "https://www.breakingbadapi.com/api/"

//moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit
private val retrofit = Retrofit.Builder()
    .client(
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    )
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    //get api characters
    @GET("characters")
    suspend fun getCharacters(): List<Character>

    //get api quotes
    @GET("quote")//quotes
    suspend fun getQuotes(
        @Query("author") author: String
    ): List<Quote>

    //get api episode
    @GET("episodes")
    suspend fun getEpisodes(): List<Episode>

    //get api death
    @GET("deaths")
    suspend fun getDeath(): List<Death>
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}