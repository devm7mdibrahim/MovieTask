package com.devm7mdibrahim.presentation.ui.movie_details

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.devm7mdibrahim.domain.model.MovieDetailsResponse
import com.devm7mdibrahim.domain.utils.DataState
import com.devm7mdibrahim.presentation.base.BaseFragment
import com.devm7mdibrahim.presentation.databinding.FragmentMovieDetailsBinding
import com.devm7mdibrahim.presentation.utils.loadImageFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    BaseFragment<FragmentMovieDetailsBinding>(FragmentMovieDetailsBinding::inflate) {

    override val viewModel by viewModels<MovieDetailsViewModel>()
    private val args by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMovieDetailsListener()
    }

    override fun onCreateBinding() {
        super.onCreateBinding()

        getMovieDetails()
    }

    private fun getMovieDetails() {
        viewModel.getMovieDetails(movieId = args.movieId)
    }

    private fun getMovieDetailsListener() {
        lifecycleScope.launchWhenStarted {
            viewModel.movieDetailsResponse.collect {
                when (it) {
                    is DataState.Success -> {
                        renderData(it.data)
                    }
                }
            }
        }
    }

    private fun renderData(data: MovieDetailsResponse) {
        with(binding) {
            ivBackground.loadImageFromUrl(data.backdropPath)
            tvTitle.text = data.title
            tvDescription.text = data.overview
        }
    }
}