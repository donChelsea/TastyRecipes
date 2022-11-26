package com.example.tastyrecipes.data.dtos.mappers

import com.example.tastyrecipes.data.dtos.*
import com.example.tastyrecipes.domain.models.*

fun RecipeDto.toDomain() = Recipe(
    name = name,
    id = id,
    prepTimeMinutes = prepTimeMinutes,
    userRating = userRating?.toDomain(),
    thumbnail = thumbnail,
    thumbnailAltText = thumbnailAltText,
    video = video,
    servings = servings,
    topics = topics.orEmpty().map { it.toDomain() },
    description = description,
    nutrition = nutrition?.toDomain(),
    instructions = instructions?.map { it.toDomain() },
    sections = sections?.map { it.toDomain() }
)

fun UserRatingDto.toDomain() = UserRating(
    score = score
)

fun TopicDto.toDomain() = Topic(
    name = name
)

fun InstructionDto.toDomain() = Instruction(
    position = position,
    text = text
)

fun NutritionDto.toDomain() = Nutrition(
    carbohydrates = carbohydrates,
    fat = fat,
    protein = protein,
    sugar = sugar,
    fiber = fiber,
    calories = calories
)

fun Nutrition.toMap() = listOf(
    Pair("Carbohydrates", this.carbohydrates),
    Pair("Fat", this.fat),
    Pair("Protein", this.protein),
    Pair("Sugar", this.sugar),
    Pair("Fiber", this.fiber),
    Pair("Calories", this.calories),
)

fun SectionDto.toDomain() = Section(
    ingredients = ingredients.filter { it.text != "n/a" }.map { it.toDomain() }
)

fun IngredientDto.toDomain() = Ingredient(
    text = text
)