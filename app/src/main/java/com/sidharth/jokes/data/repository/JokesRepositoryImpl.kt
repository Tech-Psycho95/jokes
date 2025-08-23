package com.sidharth.jokes.data.repository

import com.sidharth.jokes.data.mapper.toDomain
import com.sidharth.jokes.data.remote.source.RemoteDataSource
import com.sidharth.jokes.domain.model.Joke
import com.sidharth.jokes.domain.repository.JokesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): JokesRepository {
    override suspend fun getJoke(): Flow<Joke> = flow {
        val response = remoteDataSource.fetchJoke().toDomain()
        emit(response!!)
    }

    override suspend fun getJokes(): Flow<List<Joke>> = flow {
        val response = remoteDataSource.fetchJokes().toDomain()
        emit(response)
    }
}