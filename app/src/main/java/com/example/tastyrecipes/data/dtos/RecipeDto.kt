package com.example.tastyrecipes.data.dtos

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    val name: String,
    val id: Int,
    @SerializedName("prep_time_minutes")
    val prepTimeMinutes: Int?,
    @SerializedName("user_ratings")
    val userRating: UserRatingDto?,
    @SerializedName("thumbnail_url")
    val thumbnail: String?,
    @SerializedName("thumbnail_alt_text")
    val thumbnailAltText: String?,
    @SerializedName("original_video_url")
    val video: String?,
    @SerializedName("num_servings")
    val servings: Int?,
    val topics: List<TopicDto>?,
    val description: String?,
    val nutrition: NutritionDto?,
    val instructions: List<InstructionDto>?,
    val sections: List<SectionDto>?,
)

data class UserRatingDto(
    val score: Double
)

data class TopicDto(
    val name: String
)

data class InstructionDto(
    val position: Int,
    @SerializedName("display_text")
    val text: String,
)

data class NutritionDto(
    val carbohydrates: Int,
    val fat: Int,
    val protein: Int,
    val sugar: Int,
    val fiber: Int,
    val calories: Int,
)

data class SectionDto(
    @SerializedName("components")
    val ingredients: List<IngredientDto>
)

data class IngredientDto(
    @SerializedName("raw_text")
    val text: String
)