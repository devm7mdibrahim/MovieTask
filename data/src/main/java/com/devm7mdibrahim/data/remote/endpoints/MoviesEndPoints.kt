package com.devm7mdibrahim.data.remote.endpoints

import com.devm7mdibrahim.data.remote.utils.NetworkConstants.EndPoints.MOVIE_DETAILS
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.EndPoints.NOW_PLAYING_MOVIES
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.EndPoints.POPULAR_MOVIES
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.EndPoints.TOP_RATED_MOVIES
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.EndPoints.UPCOMING_MOVIES
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.NetworkParams.MOVIE_ID
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.NetworkParams.PAGE
import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesEndPoints {

    @GET(POPULAR_MOVIES)
    suspend fun getPopularMovies(@Query(PAGE) page: Int): MoviesResponse

    @GET(UPCOMING_MOVIES)
    suspend fun getUpcomingMovies(@Query(PAGE) page: Int): MoviesResponse

    @GET(TOP_RATED_MOVIES)
    suspend fun getTopRatedMovies(@Query(PAGE) page: Int): MoviesResponse

    @GET(NOW_PLAYING_MOVIES)
    suspend fun getNowPlayingMovies(@Query(PAGE) page: Int): MoviesResponse

    @GET("$MOVIE_DETAILS/{$MOVIE_ID}")
    suspend fun getMovieDetails(@Path(MOVIE_ID) movieId: Int): MovieDetailsResponse

}