package com.devm7mdibrahim.domain.usecase

import com.devm7mdibrahim.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend operator fun invoke(movieId: Int) = flow {
        emitAll(moviesRepository.getMovieDetails(movieId))
    }
}