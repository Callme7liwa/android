package android.isima.zzz.domain.state

import android.isima.zzz.data.model.Movie

sealed class UiState {
    object Loading : UiState()
    data class Success(val movies: List<Movie>): UiState()
    data class Error(val message: String): UiState()
}
