package com.example.universityutils.features.notes.domain.use_case

import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.domain.model.Note
import javax.inject.Inject

class GetNotes @Inject constructor(private var notesRepository: NotesRepositoryImpl) {

    suspend operator fun invoke() : List<Note> {
        return notesRepository.getAllNotes()
    }

}