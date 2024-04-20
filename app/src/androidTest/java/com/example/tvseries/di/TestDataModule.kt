package com.example.tvseries.di

import com.example.tvseries.domain.repository.MovieRepository
import com.example.tvseries.data.MovieRepositoryImpl
import com.example.tvseries.util.NetworkMonitor
import com.example.tvseries.util.TestNetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface TestDataModule {

    @Binds
    @Singleton
    fun bindRepository(repository: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    fun bindNetworkMonitor(networkMonitor: TestNetworkMonitor): NetworkMonitor

}