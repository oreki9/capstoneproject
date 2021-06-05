package com.kumastudio.capstoneproject.movie.favorite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kumastudio.capstoneproject.core.ui.MovieDataAdapter
import com.kumastudio.capstoneproject.detail.DetailMovieActivity
import com.kumastudio.capstoneproject.movie.MovieViewModel
import com.kumastudio.capstoneproject.movie.ViewModelFactory
import com.kumastudio.capstoneproject.movie.databinding.FavoriteMovieFragmentsBinding
import javax.inject.Inject

//import com.kumastudio.capstoneproject.detail.DetailMovieActivity
@Keep
class MovieFragmentFavorite(private val favoriteViewModel: MovieViewModel) : Fragment() {

    private var _binding: FavoriteMovieFragmentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteMovieFragmentsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val movieAdapter = MovieDataAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
            favoriteViewModel.movie.observe(viewLifecycleOwner, { Moviedata ->
                movieAdapter.setData(Moviedata)
                binding.viewErrorInmovie.root.visibility = if (Moviedata.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvMovieInmovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /*override fun onStop() {
        super.onStop();
        activity?.finish()
    }*/
}
