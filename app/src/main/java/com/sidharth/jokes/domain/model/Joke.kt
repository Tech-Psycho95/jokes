package com.sidharth.jokes.domain.model

import com.sidharth.jokes.core.enums.JokeType

data class Joke(
    val id: String,
    val type: JokeType,
    val data: List<String>
)