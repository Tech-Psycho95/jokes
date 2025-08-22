package com.sidharth.jokes.domain.repository

import com.sidharth.jokes.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokesRepository {

    suspend fun getJoke(): Flow<Joke>

    suspend fun getJokes(): Flow<List<Joke>>
}