package com.sidharth.jokes.data.remote.source.impl

import com.sidharth.jokes.data.remote.JokesService
import com.sidharth.jokes.data.remote.response.JokeResponse
import com.sidharth.jokes.data.remote.response.JokesResponse
import com.sidharth.jokes.data.remote.source.RemoteDataSource

class RemoteDataSourceImpl(
    private val jokesService: JokesService
): RemoteDataSource {

    override suspend fun fetchJoke(): JokeResponse {
        return jokesService.fetchJoke()
    }

    override suspend fun fetchJokes(): JokesResponse {
        return jokesService.fetchJokes()
    }

}