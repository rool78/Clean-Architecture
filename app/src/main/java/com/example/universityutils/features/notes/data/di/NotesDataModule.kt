package com.example.universityutils.features.notes.data.di

import android.content.Context
import androidx.room.Room
import com.example.universityutils.App_HiltComponents
import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.data.repository.FoodRepositoryImpl
import com.example.universityutils.features.food.domain.repository.FoodRepository
import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.data.source.NotesDatabase
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object NotesDataModule {

    @Provides
    fun provideNotesDatabase(@ApplicationContext applicationContext: Context): NotesDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideNotesDao(notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao
    }

    @Provides
    fun provideNotesRepository(notesDao: NotesDao): NotesRepository {
        return NotesRepositoryImpl(notesDao)
    }


}