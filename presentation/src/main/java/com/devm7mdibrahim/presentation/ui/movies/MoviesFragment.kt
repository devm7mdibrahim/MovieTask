package com.devm7mdibrahim.presentation.ui.movies

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devm7mdibrahim.domain.model.MovieItem
import com.devm7mdibrahim.domain.utils.DataState
import com.devm7mdibrahim.presentation.base.BaseFragment
import com.devm7mdibrahim.presentation.databinding.FragmentMoviesBinding
import com.devm7mdibrahim.presentation.utils.toGone
import com.devm7mdibrahim.presentation.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding>(FragmentMoviesBinding::inflate) {

    override val viewModel by viewModels<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMoviesListener()
    }

    override fun onCreateBinding() {
        super.onCreateBinding()
        initRVs()
        getMovies()
    }

    private val popularMoviesAdapter by lazy { MoviesAdapter { onMovieClicked(it) } }
    private val topRatedMoviesAdapter by lazy { MoviesAdapter { onMovieClicked(it) } }
    private val upcomingMoviesAdapter by lazy { MoviesAdapter { onMovieClicked(it) } }
    private val nowPlayingMoviesAdapter by lazy { MoviesAdapter { onMovieClicked(it) } }


    private fun initRVs() {
        binding.rvPopularMovies.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = popularMoviesAdapter
        }

        binding.rvTopRatedMovies.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = topRatedMoviesAdapter
        }

        binding.rvUpcomingMovies.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = upcomingMoviesAdapter
        }

        binding.rvNowPlayingMovies.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = nowPlayingMoviesAdapter
        }
    }

    private fun onMovieClicked(movieItem: MovieItem) {
        findNavController().navigate(
            MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(
                movieId = movieItem.id
            )
        )
    }

    private fun getMovies() {
        viewModel.getPopularMovies(page = 1)
        viewModel.getTopRatedMovies(page = 1)
        viewModel.getUpcomingMovies(page = 1)
        viewModel.getNowPlayingMovies(page = 1)
    }

    private fun getMoviesListener() {
        lifecycleScope.launchWhenStarted {
            viewModel.popularMoviesResponse.collect {
                when (it) {
                    is DataState.Loading -> {
                        binding.shimmerPopularMovies.toVisible()
                        binding.shimmerPopularMovies.startShimmer()
                        binding.rvPopularMovies.toGone()
                    }

                    is DataState.Success -> {
                        binding.shimmerPopularMovies.toGone()
                        binding.shimmerPopularMovies.stopShimmer()
                        binding.rvPopularMovies.toVisible()

                        popularMoviesAdapter.submitList(it.data.moviesList)
                        popularMoviesAdapter.notifyDataSetChanged()
                    }

                    is DataState.Error -> {
                        binding.shimmerPopularMovies.toGone()
                        binding.shimmerPopularMovies.stopShimmer()
                        binding.rvPopularMovies.toGone()
                        binding.tvPopularMoviesTitle.toGone()
                    }
                    is DataState.Idle -> {
                        binding.shimmerPopularMovies.toGone()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.topRatedMoviesResponse.collect {
                when (it) {
                    is DataState.Loading -> {
                        binding.shimmerTopRatedMovies.toVisible()
                        binding.shimmerTopRatedMovies.startShimmer()
                        binding.rvTopRatedMovies.toGone()
                    }
                    is DataState.Success -> {
                        binding.shimmerTopRatedMovies.toGone()
                        binding.shimmerTopRatedMovies.stopShimmer()
                        binding.rvTopRatedMovies.toVisible()

                        topRatedMoviesAdapter.submitList(it.data.moviesList)
                        topRatedMoviesAdapter.notifyDataSetChanged()
                    }
                    is DataState.Error -> {
                        binding.shimmerTopRatedMovies.toGone()
                        binding.shimmerTopRatedMovies.stopShimmer()
                        binding.rvTopRatedMovies.toGone()
                        binding.rvTopRatedMovies.toGone()
                    }
                    is DataState.Idle -> {
                        binding.shimmerTopRatedMovies.toGone()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.upcomingMoviesResponse.collect {
                when (it) {
                    is DataState.Loading -> {
                        binding.shimmerUpcomingMovies.toVisible()
                        binding.shimmerUpcomingMovies.startShimmer()
                        binding.rvUpcomingMovies.toGone()
                    }

                    is DataState.Success -> {
                        binding.shimmerUpcomingMovies.toGone()
                        binding.shimmerUpcomingMovies.stopShimmer()
                        binding.rvUpcomingMovies.toVisible()

                        upcomingMoviesAdapter.submitList(it.data.moviesList)
                        upcomingMoviesAdapter.notifyDataSetChanged()
                    }
                    is DataState.Error -> {
                        binding.shimmerUpcomingMovies.toGone()
                        binding.shimmerUpcomingMovies.stopShimmer()
                        binding.rvUpcomingMovies.toGone()
                        binding.rvUpcomingMovies.toGone()
                    }

                    is DataState.Idle -> {
                        binding.shimmerUpcomingMovies.toGone()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.nowPlayingMoviesResponse.collect {
                when (it) {
                    is DataState.Loading -> {
                        binding.shimmerNowPlayingMovies.toVisible()
                        binding.shimmerNowPlayingMovies.startShimmer()
                        binding.rvNowPlayingMovies.toGone()
                    }

                    is DataState.Success -> {
                        binding.shimmerNowPlayingMovies.toGone()
                        binding.shimmerNowPlayingMovies.stopShimmer()
                        binding.rvNowPlayingMovies.toVisible()

                        nowPlayingMoviesAdapter.submitList(it.data.moviesList)
                        nowPlayingMoviesAdapter.notifyDataSetChanged()
                    }
                    is DataState.Error -> {
                        binding.shimmerNowPlayingMovies.toGone()
                        binding.shimmerNowPlayingMovies.stopShimmer()
                        binding.rvNowPlayingMovies.toGone()
                        binding.rvNowPlayingMovies.toGone()
                    }
                    is DataState.Idle -> {
                        binding.shimmerNowPlayingMovies.toGone()
                    }
                }
            }
        }
    }
}