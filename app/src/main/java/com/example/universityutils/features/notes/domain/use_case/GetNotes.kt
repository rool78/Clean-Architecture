package com.example.universityutils.features.notes.domain.use_case

import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import javax.inject.Inject

class GetNotes @Inject constructor(private var notesRepository: NotesRepository) {

    suspend operator fun invoke() : List<Note> {
        return notesRepository.getAllNotes()
    }

}