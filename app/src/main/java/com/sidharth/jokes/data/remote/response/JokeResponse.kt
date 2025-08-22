package com.sidharth.jokes.data.remote.response


import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("safe")
    val safe: Boolean,
    @SerializedName("setup")
    val setup: String? = null,
    @SerializedName("delivery")
    val delivery: String? = null,
    @SerializedName("joke")
    val joke: String? = null,
    @SerializedName("type")
    val type: String,
)