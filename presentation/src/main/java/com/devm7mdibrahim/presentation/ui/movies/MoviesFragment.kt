package com.devm7mdibrahim.presentation.ui.movies

import androidx.fragment.app.viewModels
import com.devm7mdibrahim.presentation.base.BaseFragment
import com.devm7mdibrahim.presentation.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding>(FragmentMoviesBinding::inflate) {

    override val viewModel by viewModels<MoviesViewModel>()


}