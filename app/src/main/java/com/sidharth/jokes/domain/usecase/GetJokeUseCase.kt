package com.sidharth.jokes.domain.usecase

import com.sidharth.jokes.domain.model.Joke
import com.sidharth.jokes.domain.repository.JokesRepository
import kotlinx.coroutines.flow.Flow

class GetJokeUseCase(
    private val jokesRepository: JokesRepository
) {

    suspend fun fetchJoke(): Flow<Joke> {
        return jokesRepository.getJoke()
    }
}
