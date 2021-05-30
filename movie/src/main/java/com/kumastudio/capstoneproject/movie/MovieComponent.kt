package com.kumastudio.capstoneproject.movie

import android.content.Context
import com.kumastudio.capstoneproject.di.MovieModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [MovieModuleDependencies::class])
interface MovieComponent {

    fun inject(activity: MovieActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: MovieModuleDependencies): Builder
        fun build(): MovieComponent
    }

}