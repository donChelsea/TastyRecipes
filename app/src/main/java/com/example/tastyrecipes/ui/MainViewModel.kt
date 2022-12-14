package com.example.tastyrecipes.ui

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.repository.RecipeRepository
import com.example.tastyrecipes.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        getRecipesList()
    }

    private fun getRecipesList() {
        viewModelScope.launch {
            repository.getRecipeList().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { recipes ->
                            _uiState.value = _uiState.value.copy(data = recipes)
                        }
                    }
                    is Resource.Error -> {
                        Log.d("MainViewModel: Error: ", result.message.toString())
                    }
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }
}

@Stable
data class MainUiState(
    val data: List<Recipe> = emptyList(),
    val isLoading: Boolean? = null,
)