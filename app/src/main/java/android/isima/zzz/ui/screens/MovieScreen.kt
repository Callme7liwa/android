package android.isima.zzz.ui.screens

import android.isima.zzz.viewmodel.MovieViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel()
){
    val uniState by viewModel.uiState.collectAsState()

    MovieContent()

}