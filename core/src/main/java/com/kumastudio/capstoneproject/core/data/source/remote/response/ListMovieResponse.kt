package com.kumastudio.capstoneproject.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(

        @field:SerializedName("page")
        val page: Int,

        @field:SerializedName("results")
        val listMovies: List<MovieResponse>,

        @field:SerializedName("total_pages")
        val totalPage: Int,

        @field:SerializedName("total_results")
        val totalResult: Int
)