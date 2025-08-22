package com.sidharth.jokes.domain.model

data class Joke(
    val id: String,
    val type: JokeType,
    val data: List<String>
)