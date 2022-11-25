package com.example.tastyrecipes.data.remote

import com.example.tastyrecipes.data.dtos.RecipeDto
import com.example.tastyrecipes.data.dtos.SimpleListResultDto
import com.example.tastyrecipes.utils.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        @Query("from") from: Int = QUERY_FROM,
        @Query("size") size: Int = QUERY_SIZE,
        @Query("tags") tags: String = QUERY_TAGS,
        @Query("q") query: String = QUERY_RECIPES,
    ): SimpleListResultDto<RecipeDto>

    companion object {
        val getApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }
}