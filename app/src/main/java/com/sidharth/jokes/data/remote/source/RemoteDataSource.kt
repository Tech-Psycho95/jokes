package com.sidharth.jokes.data.remote.source

import com.sidharth.jokes.data.remote.response.JokeResponse
import com.sidharth.jokes.data.remote.response.JokesResponse

interface RemoteDataSource {

    suspend fun fetchJoke(): JokeResponse

    suspend fun fetchJokes(): JokesResponse
}