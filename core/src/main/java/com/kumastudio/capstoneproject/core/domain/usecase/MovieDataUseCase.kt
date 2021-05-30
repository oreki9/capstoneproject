package com.kumastudio.capstoneproject.core.domain.usecase

import com.kumastudio.capstoneproject.core.data.Resource
import com.kumastudio.capstoneproject.core.domain.model.MovieData
import kotlinx.coroutines.flow.Flow

interface MovieDataUseCase {
    fun getAllMovie(): Flow<Resource<List<MovieData>>>
    fun getFavoriteMovie(): Flow<List<MovieData>>
    fun setFavoriteMovie(movie: MovieData, state: Boolean)
}