package com.yeison.rick_and_morty.app.di

import com.yeison.rick_and_morty.data.api.HomeApi
import com.yeison.rick_and_morty.data.data_source.HomeDataSource
import com.yeison.rick_and_morty.data.data_source.HomeDataSourceImpl
import com.yeison.rick_and_morty.data.repository.HomeRepositoryImpl
import com.yeison.rick_and_morty.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    @Singleton
    abstract fun bindHomeDataSource(
        homeDataSourceImpl: HomeDataSourceImpl
    ): HomeDataSource

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    companion object {
        @Provides
        @Singleton
        fun provideHomeApi(retrofit: Retrofit): HomeApi =
            retrofit.create(HomeApi::class.java)
    }
}
