package com.example.tastyrecipes.data.repository

import com.example.tastyrecipes.data.remote.RecipeApi
import com.example.tastyrecipes.domain.models.Feed
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.repository.RecipeRepository
import com.example.tastyrecipes.utils.Resource
import com.example.tastyrecipes.utils.TRENDING_FEED
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
): RecipeRepository {

    override suspend fun getRecipeList(): Flow<Resource<List<Recipe>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val results = api.getRecipesList().results

        with(results) {
            emit(Resource.Success(data = this.map { it.toDomain() }))
        }

        emit(Resource.Loading(isLoading = false))
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun searchRecipes(query: String): Flow<Resource<List<Recipe>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val results = api.getRecipesList(query = query).results

        with(results) {
            emit(Resource.Success(data = this.map { it.toDomain() }))
        }

        emit(Resource.Loading(isLoading = false))
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getTrendingFeed(): Flow<Resource<Feed>> = flow {
        emit(Resource.Loading(isLoading = true))

        val results = api.getTrendingRecipes().results

        with(results) {
            emit(Resource.Success(data = this.filter { it.name == TRENDING_FEED }.getOrNull(0)?.toDomain()))
        }

        emit(Resource.Loading(isLoading = false))
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

    override suspend fun getRecipeDetails(id: Int): Flow<Resource<Recipe>> = flow {
        emit(Resource.Loading(isLoading = true))

        val result = api.getRecipeDetails(id)

        with(result) {
            emit(Resource.Success(data = this.toDomain()))
        }

        emit(Resource.Loading(isLoading = false))
    }.catch { e ->
        emit(Resource.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)

}