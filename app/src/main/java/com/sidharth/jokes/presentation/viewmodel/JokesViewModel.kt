package com.sidharth.jokes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidharth.jokes.domain.model.Joke
import com.sidharth.jokes.domain.usecase.GetJokeUseCase
import com.sidharth.jokes.domain.usecase.GetJokesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JokesViewModel(
    private val getJokes: GetJokesUseCase,
    private val getJoke: GetJokeUseCase,
) : ViewModel() {
    private val _joke = MutableStateFlow<Joke?>(null)
    val joke = _joke.asStateFlow()

    private val _jokes = MutableStateFlow<List<Joke>>(emptyList())
    val jokes = _jokes.asStateFlow()

    private val _shouldShowSingleJoke = MutableStateFlow(true)
    val shouldShowSingleJoke = _shouldShowSingleJoke.asStateFlow()

    fun fetchJokes() = viewModelScope.launch {
        getJokes.invoke().collectLatest { jokes ->
            _jokes.update { jokes }
        }
    }

    fun fetchJoke() = viewModelScope.launch {
        getJoke.invoke().collectLatest { joke ->
            _joke.update { joke }
        }
    }

    fun toggleButton() {
        _shouldShowSingleJoke.update { it.not() }
    }
}
