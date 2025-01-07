package android.isima.zzz.data.repository

import android.isima.zzz.data.api.MovieApi
import android.isima.zzz.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository (private val api: MovieApi) {

    suspend fun getMovies(): Result<List<Movie>> = withContext(Dispatchers.IO){
        try {
            val response = api.getMovies();
            if(response.isSuccessful){
                Result.success(response.body() ?: emptyList())
            }
            else{
                Result.failure(Exception("Error : ${response.code()}"))
            }
        }catch (e: Exception){
            Result.failure(e);
        }
    }

    suspend fun createMovie(movie: Movie): Result<Movie> = withContext(Dispatchers.IO){
        try {
            val response = api.createMovie(movie);
            if(response.isSuccessful){
                Result.success(response.body()!!);
            }else {
                Result.failure(Exception("error: ${response.code()}"))
            }
        }catch (e:Exception){
            Result.failure(e)
        }
    }


    suspend fun updateMovie(id: Long, movie: Movie): Result<Movie> = withContext(Dispatchers.IO) {
        try {
            val response = api.updateMovie(id, movie)
            if(response.isSuccessful){
                Result.success(response.body()!!)
            }else{
                Result.failure(Exception("error : ${response.code()}"))
            }
        }catch (e: Exception){
            Result.failure(e);
        }
    }

    suspend fun deleteMovie(id: Long): Result<Unit> = withContext(Dispatchers.IO){
        try{
            val response = api.deleteMovie(id)
            if(response.isSuccessful){
                Result.success(Unit)
            }
            else{
                Result.failure(Exception("Error: ${response.code()}"))
            }
        }catch (e: Exception){
            Result.failure(e);
        }
    }


}