package com.example.tastyrecipes.data.dtos

import com.example.tastyrecipes.domain.models.Recipe

data class RecipeDto(
    val name: String
) {
    fun toDomain() = Recipe(
        name = name
    )
}
