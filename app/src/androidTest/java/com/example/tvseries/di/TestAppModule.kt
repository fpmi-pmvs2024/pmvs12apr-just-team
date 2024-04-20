package com.example.tvseries.di

import com.example.tvseries.util.FakeMovieService
import com.example.tvseries.data.source.remote.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
class TestAppModule {
    @Singleton
    @Provides
    fun provideMovieService(): MovieService {
        return FakeMovieService
    }
}