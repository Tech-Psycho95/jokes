package com.sidharth.jokes.data.mapper

import com.sidharth.jokes.data.remote.response.JokesResponse
import com.sidharth.jokes.domain.model.Joke

fun JokesResponse.toDomain(): List<Joke> {
    return jokes.mapNotNull { it.toDomain() }
}