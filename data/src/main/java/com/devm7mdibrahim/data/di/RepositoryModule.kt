package com.devm7mdibrahim.data.di

import com.devm7mdibrahim.data.datasource.MoviesRemoteDataSource
import com.devm7mdibrahim.data.repository.MoviesRepositoryImpl
import com.devm7mdibrahim.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(moviesRemoteDataSource: MoviesRemoteDataSource): MoviesRepository =
        MoviesRepositoryImpl(moviesRemoteDataSource)

}