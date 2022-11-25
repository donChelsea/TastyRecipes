package com.example.tastyrecipes.data.repository

import com.example.tastyrecipes.data.remote.RecipeApi
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.repository.RecipeRepository
import com.example.tastyrecipes.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RecipeRepositoryImpl: RecipeRepository {

    private val api = RecipeApi.getApi

    override fun getRecipeList(): Flow<Resource<List<Recipe>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val results = api.getRecipesList().results

        with(results) {
            emit(Resource.Success(data = this.map { it.toDomain() }.also { println(it.size) }))
        }
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)
}