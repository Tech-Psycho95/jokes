package com.sidharth.jokes.data.remote.source

import com.sidharth.jokes.data.remote.response.JokeResponse

interface RemoteDataSource {

    suspend fun fetchJoke(): JokeResponse

    suspend fun fetchJokes(): List<JokeResponse>
}