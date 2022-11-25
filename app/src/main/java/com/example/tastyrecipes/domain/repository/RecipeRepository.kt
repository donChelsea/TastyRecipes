package com.example.tastyrecipes.domain.repository

import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipeList(): Flow<Resource<List<Recipe>>>
}