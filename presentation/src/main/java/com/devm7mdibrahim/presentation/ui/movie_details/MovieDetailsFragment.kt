package com.devm7mdibrahim.presentation.ui.movie_details

import androidx.fragment.app.viewModels
import com.devm7mdibrahim.presentation.base.BaseFragment
import com.devm7mdibrahim.presentation.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    BaseFragment<FragmentMovieDetailsBinding>(FragmentMovieDetailsBinding::inflate) {

    override val viewModel by viewModels<MovieDetailsViewModel>()

}