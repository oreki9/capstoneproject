package com.kumastudio.capstoneproject.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.kumastudio.capstoneproject.R
import com.kumastudio.capstoneproject.core.domain.model.MovieData
import com.kumastudio.capstoneproject.databinding.ActivityDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val detailMovie = intent.getParcelableExtra<MovieData>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(MovieDesc: MovieData?) {
        MovieDesc?.let {
            supportActionBar?.title = MovieDesc.name
            binding.content.tvDetailDescription.text = MovieDesc.description
            Glide.with(this@DetailMovieActivity)
                .load(MovieDesc.image)
                .into(binding.ivDetailImage)

            var statusFavorite = MovieDesc.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(MovieDesc, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
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
