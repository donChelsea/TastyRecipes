package com.example.tastyrecipes.ui.search

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
class SearchViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            repository.searchRecipes(query).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { recipes ->
                            _uiState.value = uiState.value.copy(recipes = recipes, query = query)
                        }
                    }
                    is Resource.Error -> {
                        Log.d("SearchViewModel: Error: ", result.message.toString())
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
data class SearchUiState(
    val recipes: List<Recipe> = emptyList(),
    val query: String = "",
    val isLoading: Boolean? = null,
)