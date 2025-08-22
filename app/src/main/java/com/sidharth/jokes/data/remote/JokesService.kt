package com.sidharth.jokes.data.remote

import com.sidharth.jokes.data.remote.response.JokeResponse

interface JokesService {

    suspend fun fetchJoke(

    ): JokeResponse

    suspend fun fetchJokes(

    ): List<JokeResponse>
}