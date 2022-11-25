package com.example.tastyrecipes.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastyrecipes.data.repository.RecipeRepositoryImpl
import com.example.tastyrecipes.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = RecipeRepositoryImpl()

    init {
        getRecipesList()
    }

    private fun getRecipesList() {
        viewModelScope.launch {
            repository.getRecipeList().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            println("MainViewModel: ${it.size}")
                        }
                    }
                    is Resource.Error -> {
                        println("MainViewModel: ${result.message.toString()}")
                    }
                    is Resource.Loading -> println(result.data)
                }
            }
        }
    }
}