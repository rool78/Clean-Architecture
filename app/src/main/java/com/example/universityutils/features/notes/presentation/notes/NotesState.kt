package com.example.universityutils.features.notes.presentation.notes

import com.example.universityutils.features.notes.domain.model.Note

data class NotesState(
    var notes: List<Note> = emptyList(),
)
