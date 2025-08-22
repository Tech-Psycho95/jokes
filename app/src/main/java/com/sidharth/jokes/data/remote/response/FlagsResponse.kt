package com.sidharth.jokes.data.remote.response


import com.google.gson.annotations.SerializedName

data class FlagsResponse(
    @SerializedName("explicit")
    val explicitResponse: Boolean,
    @SerializedName("nsfw")
    val nsfwResponse: Boolean,
    @SerializedName("political")
    val politicalResponse: Boolean,
    @SerializedName("racist")
    val racistResponse: Boolean,
    @SerializedName("religious")
    val religiousResponse: Boolean,
    @SerializedName("sexist")
    val sexistResponse: Boolean
)