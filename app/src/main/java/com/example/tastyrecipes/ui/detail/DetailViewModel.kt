package com.example.tastyrecipes.ui.detail

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
class DetailViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<DetailUiState> = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getRecipeDetails(id: Int) {
        viewModelScope.launch {
            repository.getRecipeDetails(id).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { recipe ->
                            _uiState.value = uiState.value.copy(data = recipe)
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
data class DetailUiState(
    val data: Recipe? = null,
    val isLoading: Boolean? = null,
)