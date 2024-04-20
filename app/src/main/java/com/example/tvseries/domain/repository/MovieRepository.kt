package com.example.tvseries.domain.repository

import androidx.paging.PagingData
import com.example.tvseries.domain.model.MovieDetail
import com.example.tvseries.domain.model.Movie
import com.example.tvseries.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getNowPlayingMovies(): Flow<PagingData<Movie>>

    suspend fun getTrendMovies() : Resource<List<Movie>>

    suspend fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>>

}