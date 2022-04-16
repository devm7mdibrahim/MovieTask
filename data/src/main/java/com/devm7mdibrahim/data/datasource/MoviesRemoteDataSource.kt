package com.devm7mdibrahim.data.datasource

import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.model.MoviesResponse

interface MoviesRemoteDataSource {
    suspend fun getPopularMovies(page: Int): MoviesResponse

    suspend fun getUpcomingMovies(page: Int): MoviesResponse

    suspend fun getTopRatedMovies(page: Int): MoviesResponse

    suspend fun getNowPlayingMovies(page: Int): MoviesResponse

    suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse
}