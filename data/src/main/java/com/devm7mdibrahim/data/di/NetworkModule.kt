package com.devm7mdibrahim.data.di

import com.devm7mdibrahim.data.BuildConfig
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.BASE_URL
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.LANGUAGE_EN
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.NETWORK_TIMEOUT
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.NetworkParams.API_KEY
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.NetworkParams.LANGUAGE
import com.devm7mdibrahim.data.remote.utils.NetworkConstants.TMDB_API_KEY
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun moshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun loggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .build()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val original = chain.request()

                val httpUrl = original.url().newBuilder()
                    .addQueryParameter(API_KEY, TMDB_API_KEY)
                    .addQueryParameter(LANGUAGE, LANGUAGE_EN)
                    .build()

                val request = original.newBuilder().url(httpUrl).build()
                return@addInterceptor chain.proceed(request)
            }
            .connectTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO
}
