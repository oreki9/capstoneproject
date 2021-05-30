package com.kumastudio.capstoneproject.core.data.source.local


import com.kumastudio.capstoneproject.core.data.source.local.entity.MovieEntity
import com.kumastudio.capstoneproject.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovies(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun setFavoriteTourism(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}