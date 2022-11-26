package com.example.tastyrecipes.utils

import com.example.tastyrecipes.domain.models.Nutrition
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

val mockRecipe = Recipe(
    "Original Orange Chicken by Panda Express ",
    3383,
    20,
    UserRating(
        0.8881424253
    ),
    "https://img.buzzfeed.com/tasty-app-user-assets-prod-us-east-1/recipes/1308cc4ac878420da65b1423001a9dbd.jpeg",
    "",
    "",
    8,
    listOf(Topic("chicken")),
    description = "",
    nutrition = null,
    instructions = null,
    sections = null
)

val mockNutrition = Nutrition(130, 120, 32, 54, 4, 6)