package com.kumastudio.capstoneproject.core.utils

import com.kumastudio.capstoneproject.core.data.source.local.entity.MovieEntity
import com.kumastudio.capstoneproject.core.data.source.remote.response.MovieResponse
import com.kumastudio.capstoneproject.core.domain.model.MovieData

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val MovieList = ArrayList<MovieEntity>()
        input.map {
            val movies = MovieEntity(
                    movieId = it.id,
                    description = it.overview,
                    name = it.title,
                    image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+it.poster_path,
                    isFavorite = false
            )
            MovieList.add(movies)
        }
        return MovieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<MovieData> =
            input.map {
                MovieData(
                        movieId = it.movieId,
                        description = it.description,
                        name = it.name,
                        image = it.image,
                        isFavorite = it.isFavorite
                )
            }

    fun mapDomainToEntity(input: MovieData) = MovieEntity(
            movieId = input.movieId,
            description = input.description,
            name = input.name,
            image = input.image,
            isFavorite = input.isFavorite
    )
}