package com.devm7mdibrahim.data.remote.utils

object NetworkConstants {

    const val LANGUAGE_EN = "en-US"
    const val NETWORK_TIMEOUT = 60000L
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val TMDB_API_KEY = "c50f5aa4e7c95a2a553d29b81aad6dd0"

    object EndPoints {
        const val POPULAR_MOVIES = "movie/popular"
        const val TOP_RATED_MOVIES = "movie/top_rated"
        const val NOW_PLAYING_MOVIES = "movie/now_playing"
        const val UPCOMING_MOVIES = "movie/upcoming"
        const val MOVIE_DETAILS = "movie"
    }

    object NetworkParams {
        const val LANGUAGE = "language"
        const val API_KEY = "api_key"
        const val PAGE = "page"
        const val MOVIE_ID = "movie_id"
    }
}