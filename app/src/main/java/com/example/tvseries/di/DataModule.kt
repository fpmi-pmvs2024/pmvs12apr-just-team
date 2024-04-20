package com.example.tvseries.di

import com.example.tvseries.domain.repository.MovieRepository
import com.example.tvseries.data.MovieRepositoryImpl
import com.example.tvseries.util.ConnectivityManagerNetworkMonitor
import com.example.tvseries.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindRepository(repository: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    fun bindNetworkMonitor(networkMonitor: ConnectivityManagerNetworkMonitor): NetworkMonitor
}