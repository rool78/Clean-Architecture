package com.example.universityutils.features.notes.data.source

import androidx.room.*
import com.example.universityutils.features.notes.data.model.NoteDTO
import com.example.universityutils.features.notes.domain.model.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM note_table")
    suspend fun getAll() : List<NoteDTO>

    @Insert
    suspend fun insert(note: NoteDTO)

    @Delete
    suspend fun delete(note: NoteDTO)

    @Update
    suspend fun update(note: NoteDTO)
}