package com.kumastudio.capstoneproject.di

import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataInteractor
import com.kumastudio.capstoneproject.core.domain.usecase.MovieDataUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieDataInteractor): MovieDataUseCase

}
