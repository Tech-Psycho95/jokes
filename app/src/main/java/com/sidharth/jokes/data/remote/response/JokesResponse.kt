package com.sidharth.jokes.data.remote.response

import com.google.gson.annotations.SerializedName

data class JokesResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("jokes")
    val jokes: List<JokeResponse>,
)
