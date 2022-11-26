package com.example.tastyrecipes.data.dtos.mappers

import com.example.tastyrecipes.data.dtos.FeedDto
import com.example.tastyrecipes.domain.models.Feed

fun FeedDto.toDomain() = Feed(
    name = name,
    category = category,
    items = items.map { it.toDomain() }
)