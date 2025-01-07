package android.isima.zzz.data.api

import android.isima.zzz.data.model.Movie
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MovieApi {
    @GET("api/movies")
    suspend fun  getMovies(): Response<List<Movie>>

    @GET("api/movies/{id}")
    suspend fun getMovie(@Path("id") id: Long): Response<Movie>

    @POST("api/movies")
    suspend fun createMovie(@Body movie: Movie): Response<Movie>;

    @PUT("api/movies/{id}")
    suspend fun updateMovie(@Path("id") id: Long,
                            @Body movie: Movie): Response<Movie>;

    @DELETE("api/movies/{id}")
    suspend fun deleteMovie(@Path("id") id: Long): Response<Unit>;

}