
package com.example.myapplication.services.DBService

import android.content.Context
import androidx.room.Room
import com.arjun.moviedb.services.db_service.WishlistDao
import com.arjun.moviedb.utils.DatabaseConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseService{

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context : Context) :AppDatabase{
        return  Room
            .databaseBuilder(context,AppDatabase::class.java,DatabaseConstant.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    fun provideRoom(appDatabase: AppDatabase) : MovieDao = appDatabase.movieDao()

    @Provides
    fun provideWishlistRoom(appDatabase: AppDatabase) : WishlistDao = appDatabase.wishlistDao()
}