package com.sidharth.jokes.domain.usecase

import com.sidharth.jokes.domain.model.Joke
import com.sidharth.jokes.domain.repository.JokesRepository
import kotlinx.coroutines.flow.Flow

class GetJokesUseCase(
    private val jokesRepository: JokesRepository
) {
    
    suspend fun invoke(): Flow<List<Joke>> {
        return jokesRepository.getJokes()
    }
}