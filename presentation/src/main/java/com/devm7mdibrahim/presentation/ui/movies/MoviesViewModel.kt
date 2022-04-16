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
}