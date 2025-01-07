package android.isima.zzz.viewmodel
import android.isima.zzz.data.repository.MovieRepository
import android.isima.zzz.domain.state.UiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies(){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                repository.fetchMovies()
                    .fold(
                        onSuccess = { movies ->
                            _uiState.value = UiState.Success(movies)
                        },
                        onFailure = { exception ->
                            _uiState.value = UiState.Error(
                                exception.message ?: "Une erreur est survenu"
                            )
                        }
                    )
            }catch (e: Exception){
                _uiState.value = UiState.Error(
                    e.message ?: "Une erreur inattendu est survenu"
                )
            }
        }
    }
}

