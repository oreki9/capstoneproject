package com.kumastudio.capstoneproject.core.di


import android.content.Context
import androidx.room.Room
import com.kumastudio.capstoneproject.core.data.source.local.room.MovieDao
import com.kumastudio.capstoneproject.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase = Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movies.db"
    ).fallbackToDestructiveMigration().openHelperFactory(SupportFactory(SQLiteDatabase.getBytes("PassPhrase".toCharArray()))).build()

    @Provides
    fun provideTourismDao(database: MovieDatabase): MovieDao = database.movieDao()
}