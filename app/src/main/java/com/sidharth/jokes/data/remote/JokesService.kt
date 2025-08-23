package com.sidharth.jokes.data.remote

import com.sidharth.jokes.core.constants.AppConstants
import com.sidharth.jokes.data.remote.response.JokeResponse
import com.sidharth.jokes.data.remote.response.JokesResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesService {

    @GET("Any")
    suspend fun fetchJoke(): JokeResponse

    @GET("Any")
    suspend fun fetchJokes(
        @Query("amount") amount: Int = 10,
    ): JokesResponse
}

fun getJokesService(): JokesService {
    val retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(JokesService::class.java)
}