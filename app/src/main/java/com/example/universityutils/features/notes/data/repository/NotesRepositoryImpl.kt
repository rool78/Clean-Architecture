package com.example.universityutils.features.notes.data.repository

import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import javax.inject.Inject

class NotesRepositoryImpl (private var dao: NotesDao) : NotesRepository {

    override suspend fun getAllNotes(): List<Note> {
        return dao.getAll()
    }

    override suspend fun insertNote(note: Note) {
        dao.insert(note)
    }
}