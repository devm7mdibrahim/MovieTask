package com.devm7mdibrahim.data.di

import com.devm7mdibrahim.data.remote.endpoints.MoviesEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EndPointsModule {

    @Provides
    @Singleton
    fun provideMoviesEndPoints(retrofit: Retrofit): MoviesEndPoints =
        retrofit.create(MoviesEndPoints::class.java)
}