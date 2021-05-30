package com.kumastudio.capstoneproject.core.data


import com.kumastudio.capstoneproject.core.data.source.local.LocalDataSource
import com.kumastudio.capstoneproject.core.data.source.remote.RemoteDataSource
import com.kumastudio.capstoneproject.core.data.source.remote.network.ApiResponse
import com.kumastudio.capstoneproject.core.data.source.remote.response.MovieResponse
import com.kumastudio.capstoneproject.core.domain.model.MovieData
import com.kumastudio.capstoneproject.core.domain.repository.IMovieRepository
import com.kumastudio.capstoneproject.core.utils.AppExecutors
import com.kumastudio.capstoneproject.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<MovieData>>> =
            object : NetworkBoundResource<List<MovieData>, List<MovieResponse>>() {
                override fun loadFromDB(): Flow<List<MovieData>> {
                    return localDataSource.getAllMovies().map {
                        DataMapper.mapEntitiesToDomain(it)
                    }
                }

                override fun shouldFetch(data: List<MovieData>?): Boolean =
//                data == null || data.isEmpty()
                        true

                override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                        remoteDataSource.getAllTourism()

                override suspend fun saveCallResult(data: List<MovieResponse>) {
                    val tourismList = DataMapper.mapResponsesToEntities(data)
                    localDataSource.insertMovies(tourismList)
                }
            }.asFlow()

    override fun getFavoriteMovie(): Flow<List<MovieData>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: MovieData, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

