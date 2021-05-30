package com.kumastudio.capstoneproject.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val movieUseCase: MovieDataUseCase) :
        ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                    MovieViewModel(movieUseCase) as T
                }
                else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
            }
}