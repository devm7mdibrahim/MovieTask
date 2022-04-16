package com.devm7mdibrahim.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "results") val moviesList: List<MovieItem>?
)

data class MovieItem(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String?,
    @Json(name = "overview") val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "video") val video: Boolean?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "popularity") val popularity: Double?,
    @Json(name = "vote_average") val voteAverage: Double?,
    @Json(name = "adult") val adult: Boolean?,
    @Json(name = "vote_count") val voteCount: Int?
)