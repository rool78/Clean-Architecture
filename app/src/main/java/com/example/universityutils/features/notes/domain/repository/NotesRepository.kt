package com.example.universityutils.features.notes.domain.repository

import com.example.universityutils.features.notes.domain.model.Note

interface NotesRepository {

    suspend fun getAllNotes() : List<Note>

    suspend fun insertNote(note: Note)
}