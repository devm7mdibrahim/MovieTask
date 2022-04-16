package com.devm7mdibrahim.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsResponse(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "title") val title: String?,
    @Json(name = "overview") val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "original_language") val originalLanguage: String?,
    @Json(name = "imdb_id") val imdbId: String?,
    @Json(name = "video") val video: Boolean?,
    @Json(name = "revenue") val revenue: Int?,
    @Json(name = "popularity") val popularity: Double?,
    @Json(name = "vote_count") val voteCount: Int?,
    @Json(name = "budget") val budget: Double?,
    @Json(name = "original_title") val originalTitle: String?,
    @Json(name = "runtime") val runtime: Int?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Double?,
    @Json(name = "tagline") val tagline: String?,
    @Json(name = "adult") val adult: Boolean?,
    @Json(name = "homepage") val homepage: String?,
    @Json(name = "status") val status: String?
)


