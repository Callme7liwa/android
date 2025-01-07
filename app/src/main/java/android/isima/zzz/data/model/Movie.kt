package android.isima.zzz.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val rating: Float
)
