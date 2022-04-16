package com.devm7mdibrahim.domain.usecase

import com.devm7mdibrahim.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(page: Int) = flow {
        emitAll(moviesRepository.getPopularMovies(page))
    }
}