package com.kumastudio.capstoneproject.core.data.source.remote.network

import com.kumastudio.capstoneproject.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie?sort_by=popularity.desc&api_key=a19074849353b0c6b6a3e101b18eb382")
    suspend fun getListMovie(): ListMovieResponse
}
