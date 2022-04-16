package com.devm7mdibrahim.data.repository

import com.devm7mdibrahim.data.datasource.MoviesRemoteDataSource
import com.devm7mdibrahim.data.remote.utils.safeApiCall
import com.devm7mdibrahim.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesRemoteDataSource: MoviesRemoteDataSource) :
    MoviesRepository {

    override suspend fun getPopularMovies(page: Int) = safeApiCall {
        moviesRemoteDataSource.getPopularMovies(page)
    }

    override suspend fun getUpcomingMovies(page: Int) = safeApiCall {
        moviesRemoteDataSource.getUpcomingMovies(page)
    }

    override suspend fun getTopRatedMovies(page: Int) = safeApiCall {
        moviesRemoteDataSource.getTopRatedMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int) = safeApiCall {
        moviesRemoteDataSource.getNowPlayingMovies(page)
    }

    override suspend fun getMovieDetails(movieId: Int) = safeApiCall {
        moviesRemoteDataSource.getMovieDetails(movieId)
    }

}