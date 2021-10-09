package com.example.universityutils.features.notes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.universityutils.features.notes.domain.model.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM note_table")
    suspend fun getAll() : List<Note>

    @Insert
    suspend fun insert(note: Note)

}