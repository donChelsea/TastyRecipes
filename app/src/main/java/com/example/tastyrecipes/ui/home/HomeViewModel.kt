package com.example.tastyrecipes.ui.home

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastyrecipes.domain.models.Feed
import com.example.tastyrecipes.domain.repository.RecipeRepository
import com.example.tastyrecipes.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getTrendingFeed()
    }

    private fun getTrendingFeed() {
        viewModelScope.launch {
            repository.getTrendingFeed().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { feed ->
                            _uiState.value = _uiState.value.copy(data = feed)
                        }
                    }
                    is Resource.Error -> {
                        Log.d("HomeViewModel: Error", result.message.toString())
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
data class HomeUiState(
    val data: Feed? = null,
    val isLoading: Boolean? = null,
)