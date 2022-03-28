package com.example.universityutils.features.notes.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.universityutils.features.notes.data.model.NoteDTO
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.repository.NotesRepository

@Database(entities = [NoteDTO::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract val notesDao: NotesDao

}