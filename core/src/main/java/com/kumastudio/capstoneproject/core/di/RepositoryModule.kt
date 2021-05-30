package com.kumastudio.capstoneproject.core.di

import com.kumastudio.capstoneproject.core.data.MovieRepository
import com.kumastudio.capstoneproject.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: MovieRepository): IMovieRepository

}