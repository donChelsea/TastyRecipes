package com.example.tastyrecipes.di

import com.example.tastyrecipes.data.remote.RecipeApi
import com.example.tastyrecipes.data.repository.RecipeRepositoryImpl
import com.example.tastyrecipes.domain.repository.RecipeRepository
import com.example.tastyrecipes.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object AppModule {

    @Provides
    @Singleton
    fun provideOfficeApi(): RecipeApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)

    @Provides
    @Singleton
    fun provideOfficeRepository(api: RecipeApi): RecipeRepository = RecipeRepositoryImpl(api)

}