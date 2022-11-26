package com.example.tastyrecipes.utils

import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.models.Topic
import com.example.tastyrecipes.domain.models.UserRating

const val BASE_URL = "https://tasty.p.rapidapi.com/"

const val RECIPES_FROM = 0
const val RECIPES_SIZE = 20
const val RECIPES_TAGS = ""
const val RECIPES_QUERY = ""

const val FEED_SIZE = 0
const val FEED_TIMEZONE = "%2B0500"
const val FEED_VEGETARIAN = false
const val FEED_FROM = 0

const val TRENDING_FEED = "Trending"

const val DELIMITER = ", "

val mockRecipe = Recipe(
    "Original Orange Chicken by Panda Express ",
    3383,
    20,
    UserRating(
        0.8881424253
    ),
    "",
    "",
    "",
    8,
    listOf(Topic("chicken"))
)