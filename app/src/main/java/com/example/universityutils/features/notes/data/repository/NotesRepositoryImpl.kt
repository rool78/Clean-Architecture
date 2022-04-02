package com.example.universityutils.features.notes.data.repository

import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.data.toDomain
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import javax.inject.Inject

class NotesRepositoryImpl (private val dao: NotesDao) : NotesRepository {

    override suspend fun getAllNotes(): List<Note> {
        return dao.getAll().map {
            it.toDomain()
        }
    }

    override suspend fun insertNote(note: Note) {
        dao.insert(note.toDomain())
    }

    override suspend fun updateNote(note: Note) {
        dao.update(note.toDomain())
    }

    override suspend fun deleteNote(note: Note) {
        dao.delete(note.toDomain())
    }
}