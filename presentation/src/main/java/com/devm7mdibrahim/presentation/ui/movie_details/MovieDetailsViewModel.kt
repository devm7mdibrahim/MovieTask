package com.devm7mdibrahim.presentation.ui.movie_details

import androidx.lifecycle.viewModelScope
import com.devm7mdibrahim.domain.usecase.GetMovieDetailsUseCase
import com.devm7mdibrahim.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
    BaseViewModel() {

        init {
            viewModelScope.launch {
                getMovieDetailsUseCase(667257)
            }
        }
}