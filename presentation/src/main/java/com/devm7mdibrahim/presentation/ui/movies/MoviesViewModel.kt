package com.devm7mdibrahim.presentation.ui.movies

import androidx.lifecycle.viewModelScope
import com.devm7mdibrahim.domain.model.MoviesResponse
import com.devm7mdibrahim.domain.usecase.*
import com.devm7mdibrahim.domain.utils.DataState
import com.devm7mdibrahim.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : BaseViewModel() {

    private val _popularMoviesResponse =
        MutableStateFlow<DataState<MoviesResponse>>(DataState.Idle)
    val popularMoviesResponse: MutableStateFlow<DataState<MoviesResponse>>
        get() = _popularMoviesResponse

    fun getPopularMovies(page: Int) {
        viewModelScope.launch {
            getPopularMoviesUseCase(page)
                .onEach {
                    _popularMoviesResponse.value = it
                }.launchIn(viewModelScope)
        }
    }

    private val _topRatedMoviesResponse =
        MutableStateFlow<DataState<MoviesResponse>>(DataState.Idle)
    val topRatedMoviesResponse: MutableStateFlow<DataState<MoviesResponse>>
        get() = _topRatedMoviesResponse

    fun getTopRatedMovies(page: Int) {
        viewModelScope.launch {
            getTopRatedMoviesUseCase(page)
                .onEach {
                    _topRatedMoviesResponse.value = it
                }.launchIn(viewModelScope)
        }
    }

    private val _upcomingMoviesResponse =
        MutableStateFlow<DataState<MoviesResponse>>(DataState.Idle)
    val upcomingMoviesResponse: MutableStateFlow<DataState<MoviesResponse>>
        get() = _upcomingMoviesResponse

    fun getUpcomingMovies(page: Int) {
        viewModelScope.launch {
            getUpcomingMoviesUseCase(page)
                .onEach {
                    _upcomingMoviesResponse.value = it
                }.launchIn(viewModelScope)
        }
    }

    private val _nowPlayingMoviesResponse =
        MutableStateFlow<DataState<MoviesResponse>>(DataState.Idle)
    val nowPlayingMoviesResponse: MutableStateFlow<DataState<MoviesResponse>>
        get() = _nowPlayingMoviesResponse

    fun getNowPlayingMovies(page: Int) {
        viewModelScope.launch {
            getNowPlayingMoviesUseCase(page)
                .onEach {
                    _nowPlayingMoviesResponse.value = it
                }.launchIn(viewModelScope)
        }
    }
}