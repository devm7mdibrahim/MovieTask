package com.devm7mdibrahim.domain.repository

import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.model.MoviesResponse
import com.devm7mdibrahim.domain.utils.DataState
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getPopularMovies(page: Int): Flow<DataState<MoviesResponse>>

    suspend fun getUpcomingMovies(page: Int): Flow<DataState<MoviesResponse>>

    suspend fun getTopRatedMovies(page: Int): Flow<DataState<MoviesResponse>>

    suspend fun getNowPlayingMovies(page: Int): Flow<DataState<MoviesResponse>>

    suspend fun getMovieDetails(movieId: Int): Flow<DataState<MovieDetailsResponse>>
}