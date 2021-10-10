package com.example.universityutils.di

import android.content.Context
import androidx.room.Room
import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.data.source.NotesDatabase
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import com.example.universityutils.features.notes.domain.use_case.AddNote
import com.example.universityutils.features.notes.domain.use_case.GetNotes
import com.example.universityutils.features.notes.domain.use_case.NotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext applicationContext: Context) : NotesDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(notesDatabase: NotesDatabase) : NotesDao {
        return notesDatabase.notesDao
    }

    @Provides
    @Singleton
    fun provideNotesRepository(notesDao: NotesDao) : NotesRepository {
        return NotesRepositoryImpl(notesDao)
    }

    @Provides
    @Singleton
    fun provideNotesUseCase(notesRepository: NotesRepository) : NotesUseCase {
        return NotesUseCase(AddNote(notesRepository),
                            GetNotes(notesRepository)
        )
    }

}