package com.example.universityutils.features.notes.domain.use_case

import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import javax.inject.Inject

class AddNote @Inject constructor(private var notesRepository: NotesRepository) {

    suspend operator fun invoke(note : Note) {
        notesRepository.insertNote(note)
    }
}