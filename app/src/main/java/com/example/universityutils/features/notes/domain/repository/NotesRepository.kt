package com.example.universityutils.features.notes.domain.repository

import com.example.universityutils.features.notes.domain.model.Note

interface NotesRepository {

    fun getAllNotes() : List<Note>

    fun insertNote(note: Note)
}