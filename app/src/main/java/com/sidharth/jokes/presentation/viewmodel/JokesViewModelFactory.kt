package com.sidharth.jokes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sidharth.jokes.data.remote.JokesService
import com.sidharth.jokes.data.remote.getJokesService
import com.sidharth.jokes.data.remote.source.RemoteDataSource
import com.sidharth.jokes.data.remote.source.impl.RemoteDataSourceImpl
import com.sidharth.jokes.data.repository.JokesRepositoryImpl
import com.sidharth.jokes.domain.repository.JokesRepository
import com.sidharth.jokes.domain.usecase.GetJokeUseCase
import com.sidharth.jokes.domain.usecase.GetJokesUseCase

class JokesViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val jokesService: JokesService = getJokesService()
        val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl(jokesService)

        val jokesRepository: JokesRepository = JokesRepositoryImpl(remoteDataSource)
        val getJokeUseCase = GetJokeUseCase(jokesRepository)
        val getJokesUseCase = GetJokesUseCase(jokesRepository)

        if (modelClass.isAssignableFrom(JokesViewModel::class.java)) {
            return JokesViewModel(
                getJokes = getJokesUseCase,
                getJoke = getJokeUseCase,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
