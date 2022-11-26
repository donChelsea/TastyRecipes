package com.example.tastyrecipes.domain.repository

import com.example.tastyrecipes.domain.models.Feed
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipeList(): Flow<Resource<List<Recipe>>>

    suspend fun searchRecipes(query: String): Flow<Resource<List<Recipe>>>

    suspend fun getTrendingFeed(): Flow<Resource<Feed>>

    suspend fun getRecipeDetails(id: Int): Flow<Resource<Recipe>>
}