package com.kumastudio.capstoneproject.core.domain.usecase


import com.kumastudio.capstoneproject.core.domain.model.MovieData
import com.kumastudio.capstoneproject.core.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieDataInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieDataUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: MovieData, state: Boolean) = movieRepository.setFavoriteMovie(movie, state)
}