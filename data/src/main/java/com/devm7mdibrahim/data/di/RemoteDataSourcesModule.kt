package com.devm7mdibrahim.data.di

import com.devm7mdibrahim.data.datasource.MoviesRemoteDataSource
import com.devm7mdibrahim.data.remote.datasource.MoviesRemoteDataSourceImpl
import com.devm7mdibrahim.data.remote.endpoints.MoviesEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourcesModule {

    @Provides
    @Singleton
    fun provideMoviesRemoteDataSource(moviesEndPoints: MoviesEndPoints): MoviesRemoteDataSource =
        MoviesRemoteDataSourceImpl(moviesEndPoints)
}