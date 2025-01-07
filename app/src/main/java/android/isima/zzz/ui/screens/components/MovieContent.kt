package android.isima.zzz.ui.screens.components

import android.graphics.Paint.Align
import android.isima.zzz.data.model.Movie
import android.isima.zzz.domain.state.UiState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieContent(
    uiState: UiState,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = onRefresh,
            modifier = modifier.align(Alignment.End)
        ){
            Text("Refraichir")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when(uiState){
            is UiState.Loading -> LoadingContent()
            is UiState.Success -> MovieLi
        }
    }
}

@Composable
fun MovieList(movies: List<Movie>){
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(
            items = movies,
            key = {it.id}
        ){ movie -> MovieItem(movie) }
    }
}

@Composable
fun LoadingContent(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorContent(message: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

