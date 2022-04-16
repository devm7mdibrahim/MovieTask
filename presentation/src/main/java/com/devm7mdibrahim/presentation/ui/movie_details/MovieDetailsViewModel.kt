package com.devm7mdibrahim.presentation.ui.movie_details

import androidx.lifecycle.viewModelScope
import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.model.MoviesResponse
import com.devm7mdibrahim.domain.usecase.GetMovieDetailsUseCase
import com.devm7mdibrahim.domain.utils.DataState
import com.devm7mdibrahim.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
    BaseViewModel() {


    private val _movieDetailsResponse =
        MutableStateFlow<DataState<MovieDetailsResponse>>(DataState.Idle)
    val movieDetailsResponse: MutableStateFlow<DataState<MovieDetailsResponse>>
        get() = _movieDetailsResponse

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailsUseCase(movieId)
                .onEach {
                    _movieDetailsResponse.value = it
                }.launchIn(viewModelScope)
        }
    }
}