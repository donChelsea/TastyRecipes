package com.example.tastyrecipes.data.dtos

import com.example.tastyrecipes.domain.models.Feed

data class FeedDto(
    val name: String,
    val category: String,
    val items: List<RecipeDto>
) {
    fun toDomain() = Feed(
        name = name,
        category = category,
        items = items.map { it.toDomain() }
    )
}
