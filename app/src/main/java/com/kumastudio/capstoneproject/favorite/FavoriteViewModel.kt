package com.kumastudio.capstoneproject.favorite

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase

class FavoriteViewModel @ViewModelInject constructor(movieUseCase: MovieDataUseCase) : ViewModel() {
    val favoriteTourism = movieUseCase.getFavoriteMovie().asLiveData()
}