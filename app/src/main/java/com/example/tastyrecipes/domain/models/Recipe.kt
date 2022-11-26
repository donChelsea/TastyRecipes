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
    val topics: List<Topic>?,
    val description: String?,
    val nutrition: Nutrition?,
    val instructions: List<Instruction>?,
    val sections: List<Section>?,
)

data class UserRating(
    val score: Double
)

data class Topic(
    val name: String
)

data class Instruction(
    val position: Int,
    val text: String,
)

data class Nutrition(
    val carbohydrates: Int,
    val fat: Int,
    val protein: Int,
    val sugar: Int,
    val fiber: Int,
    val calories: Int,
)

data class Section(
    val ingredients: List<Ingredient>
)

data class Ingredient(
    val text: String
)