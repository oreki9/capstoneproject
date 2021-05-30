package com.kumastudio.capstoneproject.movie


import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kumastudio.capstoneproject.core.data.Resource
import com.kumastudio.capstoneproject.di.MovieModuleDependencies
import com.kumastudio.capstoneproject.movie.databinding.ActivityMoviesBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val movieViewModel: MovieViewModel by viewModels {
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

        getMovieData()
    }

    private fun getMovieData() {
        movieViewModel.movie.observe(this, { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is movies of ${movie.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = movie.message
                    }
                }
            }
        })
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