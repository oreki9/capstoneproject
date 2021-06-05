package com.kumastudio.capstoneproject.movie


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.kumastudio.capstoneproject.R
import com.kumastudio.capstoneproject.core.data.Resource
import com.kumastudio.capstoneproject.di.MovieModuleDependencies
import com.kumastudio.capstoneproject.home.HomeFragment
import com.kumastudio.capstoneproject.movie.databinding.ActivityMoviesBinding
import com.kumastudio.capstoneproject.movie.favorite.MovieFragmentFavorite

import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject
@Keep
class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val movieViewModel: MovieViewModel by viewModels{
        factory
    }

    private lateinit var binding: ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMovieComponent.builder()
                .context(this)
                .appDependencies(
                        EntryPointAccessors.fromApplication(
                                applicationContext,
                                MovieModuleDependencies::class.java
                        )
                )
                .build()
                .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Movie Data"
        getFavorite()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun getFavorite(){
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        fragment = MovieFragmentFavorite(movieViewModel)
        title = getString(R.string.app_name)
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(getResources().getIdentifier("nav_host_fragment_movie", "id", "com.kumastudio.capstoneproject.movie"), fragment)
                .commit()
        }
        val toolbar = findViewById<Toolbar>(getResources().getIdentifier("toolbarMovie", "id", "com.kumastudio.capstoneproject.movie"))
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q &&
            isTaskRoot &&
            supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.backStackEntryCount ?: 0 == 0 &&
            supportFragmentManager.backStackEntryCount == 0
        ) {
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
}