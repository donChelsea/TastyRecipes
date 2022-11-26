package com.example.tastyrecipes.data.remote

import com.example.tastyrecipes.data.dtos.FeedDto
import com.example.tastyrecipes.data.dtos.RecipeDto
import com.example.tastyrecipes.data.dtos.SimpleListResultDto
import com.example.tastyrecipes.utils.*
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeApi {

    @Headers(
        "X-RapidAPI-Key: 7611d2cd3fmsh22f441ac2b4cffcp1d68bejsn13399318f70b",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    @GET("recipes/list")
    suspend fun getRecipesList(
        @Query("from") from: Int = RECIPES_FROM,
        @Query("size") size: Int = RECIPES_SIZE,
        @Query("tags") tags: String = RECIPES_TAGS,
        @Query("q") query: String = RECIPES_QUERY,
    ): SimpleListResultDto<RecipeDto>

    @Headers(
        "X-RapidAPI-Key: 7611d2cd3fmsh22f441ac2b4cffcp1d68bejsn13399318f70b",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    @GET("feeds/list")
    suspend fun getTrendingRecipes(
        @Query("size") size: Int = FEED_SIZE,
        @Query("timezone") timezone: String = FEED_TIMEZONE,
        @Query("vegetarian") vegetarian: Boolean = FEED_VEGETARIAN,
        @Query("from") from: Int = FEED_FROM,
    ): SimpleListResultDto<FeedDto>

    @Headers(
        "X-RapidAPI-Key: 7611d2cd3fmsh22f441ac2b4cffcp1d68bejsn13399318f70b",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    @GET("recipes/get-more-info")
    suspend fun getRecipeDetails(
        @Query("id") id: Int,
    ): RecipeDto
}