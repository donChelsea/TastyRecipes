package com.example.tastyrecipes.domain.models

data class Recipe(
    val name: String,
    val id: Int,
    val prepTimeMinutes: Int?,
    val userRating: UserRating?,
    val thumbnail: String?,
    val thumbnailAltText: String?,
    val video: String?,
    val servings: Int?,
    val topics: List<Topic>?

)

data class UserRating(
    val score: Double
)

data class Topic(
    val name: String
)