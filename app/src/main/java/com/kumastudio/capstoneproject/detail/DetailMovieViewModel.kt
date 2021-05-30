package com.kumastudio.capstoneproject.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kumastudio.capstoneproject.core.domain.model.MovieData
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase

class DetailMovieViewModel @ViewModelInject constructor(private val movieUseCase: MovieDataUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: MovieData, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}

