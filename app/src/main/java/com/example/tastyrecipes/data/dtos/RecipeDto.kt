package com.example.tastyrecipes.data.dtos

import com.example.tastyrecipes.domain.models.*
import com.example.tastyrecipes.utils.DELIMITER
import com.google.gson.annotations.SerializedName

data class RecipeDto(
    val name: String,
    val id: Int,
    @SerializedName("prep_time_minutes")
    val prepTimeMinutes: Int,
    @SerializedName("user_ratings")
    val userRating: UserRatingDto,
    @SerializedName("thumbnail_url")
    val thumbnail: String,
    @SerializedName("thumbnail_alt_text")
    val thumbnailAltText: String,
    @SerializedName("original_video_url")
    val video: String,
    @SerializedName("num_servings")
    val servings: Int,
    val topics: List<TopicDto>,
) {
    fun toDomain() = Recipe(
        name = name,
        id = id,
        prepTimeMinutes = prepTimeMinutes,
        userRating = userRating.toDomain(),
        thumbnail = thumbnail,
        thumbnailAltText = thumbnailAltText,
        video = video,
        servings = servings,
        topics = topics.map { it.toDomain() },
    )
}

data class UserRatingDto(
    val score: Double
) {
    fun toDomain() = UserRating(
        score = score
    )
}

data class TopicDto(
    val name: String
) {
    fun toDomain() = Topic(
        name = name
    )
}