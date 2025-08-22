package com.sidharth.jokes.data.mapper

import com.sidharth.jokes.data.remote.response.JokeResponse
import com.sidharth.jokes.domain.model.Joke
import com.sidharth.jokes.domain.model.JokeType

fun JokeResponse.toDomain(): Joke? {
    val type = JokeType.fromType(type)
    val data = type?.let { getData(it) }

    return data?.let {
        Joke(
            id = "$id",
            data = it,
            type = type
        )
    }
}

private fun JokeResponse.getData(
    type: JokeType
): List<String>? {
    if (type == JokeType.SINGLE) {
        return listOf(joke!!)
    }

    if (type == JokeType.TWO_PART) {
        return listOf(setup!!, delivery!!)
    }

    return null
}