package com.kumastudio.capstoneproject.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase

class MovieViewModel(movieUseCase: MovieDataUseCase) : ViewModel() {
    val movie = movieUseCase.getFavoriteMovie().asLiveData()
}