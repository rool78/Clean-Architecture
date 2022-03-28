package com.example.universityutils.features.notes.data

import com.example.universityutils.features.notes.data.model.NoteDTO
import com.example.universityutils.features.notes.domain.model.Note

fun NoteDTO.toDomain() : Note {
    return Note(
        id = id,
        title = title,
        text = text,
        time = time //TODO to Date
    )
}

fun Note.toDomain() : NoteDTO {
    return NoteDTO(
        id = id,
        title = title,
        text = text,
        time = time
    )
}