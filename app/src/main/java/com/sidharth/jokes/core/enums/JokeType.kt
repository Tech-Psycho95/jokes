package com.sidharth.jokes.core.enums

enum class JokeType(
    private val key: String
) {
    SINGLE("single"), TWO_PART("twopart");

    companion object {
        fun fromType(type: String): JokeType? {
            return when (type) {
                SINGLE.key -> SINGLE
                TWO_PART.key -> TWO_PART
                else -> null
            }
        }
    }
}