package com.kumastudio.capstoneproject.core.data.source.remote
import android.util.Log
import com.kumastudio.capstoneproject.core.data.source.remote.network.ApiResponse
import com.kumastudio.capstoneproject.core.data.source.remote.network.ApiService
import com.kumastudio.capstoneproject.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllTourism(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getListMovie()
                val dataArray = response.listMovies
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.listMovies))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

