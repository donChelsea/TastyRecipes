package com.example.tastyrecipes.domain.models

data class Feed(
    val name: String,
    val category: String,
    val items: List<Recipe>
)
