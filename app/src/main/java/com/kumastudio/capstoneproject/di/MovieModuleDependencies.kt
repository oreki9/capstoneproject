package com.kumastudio.capstoneproject.di

import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface MovieModuleDependencies {
    fun movieUseCase(): MovieDataUseCase
}