package com.example.examen.di

import android.app.Application
import androidx.room.Room
import com.example.examen.data.local.db.AppDatabase
import com.example.examen.data.remote.api.BookApiService
import com.example.examen.data.remote.api.RetrofitInstance
import com.example.examen.data.repository.BookRepositoryImpl
import com.example.examen.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): BookApiService = RetrofitInstance.api

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "books_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideBookDao(db: AppDatabase) = db.bookDao()

    @Provides
    @Singleton
    fun provideRepository(
        api: BookApiService,
        db: AppDatabase
    ): BookRepository {
        return BookRepositoryImpl(api, db.bookDao())
    }
}