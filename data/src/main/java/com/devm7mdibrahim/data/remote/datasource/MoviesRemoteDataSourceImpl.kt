package com.devm7mdibrahim.data.remote.datasource

import com.devm7mdibrahim.data.datasource.MoviesRemoteDataSource
import com.devm7mdibrahim.data.remote.endpoints.MoviesEndPoints
import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.model.MoviesResponse
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(private val moviesEndPoints: MoviesEndPoints) :
    MoviesRemoteDataSource {

    override suspend fun getPopularMovies(page: Int): MoviesResponse {
        return moviesEndPoints.getPopularMovies(page)
    }

    override suspend fun getUpcomingMovies(page: Int): MoviesResponse {
        return moviesEndPoints.getUpcomingMovies(page)
    }

    override suspend fun getTopRatedMovies(page: Int): MoviesResponse {
        return moviesEndPoints.getTopRatedMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int): MoviesResponse {
        return moviesEndPoints.getNowPlayingMovies(page)
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse {
        return moviesEndPoints.getMovieDetails(movieId)
    }

}