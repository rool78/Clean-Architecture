package com.example.universityutils.features.notes.data.di

import android.content.Context
import androidx.room.Room
import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.data.source.NotesDatabase
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

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
    fun provideNotesDao(notesDatabase: NotesDatabase): NotesDao = notesDatabase.notesDao


    @Provides
    fun provideNotesRepository(notesDao: NotesDao): NotesRepository = NotesRepositoryImpl(notesDao)


}