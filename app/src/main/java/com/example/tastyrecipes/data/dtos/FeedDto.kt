package com.example.tastyrecipes.data.dtos

data class FeedDto(
    val name: String,
    val category: String,
    val items: List<RecipeDto>
)
