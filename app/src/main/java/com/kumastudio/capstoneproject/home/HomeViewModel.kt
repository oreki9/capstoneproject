package com.kumastudio.capstoneproject.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase

class HomeViewModel @ViewModelInject constructor(moviedataUseCase: MovieDataUseCase) : ViewModel() {
    val moviedata = moviedataUseCase.getAllMovie().asLiveData()
}
