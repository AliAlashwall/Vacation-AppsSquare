package com.example.appssquaretask.di

import com.example.appssquaretask.data.remote.RetrofitServices
import com.example.appssquaretask.data.repositoryImpl.AuthRepositoryImpl
import com.example.appssquaretask.data.repositoryImpl.CitiesRepositoryImpl
import com.example.appssquaretask.domain.repository.AuthRepository
import com.example.appssquaretask.domain.repository.CitiesRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://android-training.appssquare.com/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitService(baseUrl: String, okHttpClient: OkHttpClient): RetrofitServices {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(RetrofitServices::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(retrofitService: RetrofitServices): AuthRepository {
        return AuthRepositoryImpl(retrofitService)
    }

    @Provides
    @Singleton
    fun provideCitiesRepository(retrofitService: RetrofitServices): CitiesRepository {
        return CitiesRepositoryImpl(retrofitService)
    }
}