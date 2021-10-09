package com.example.universityutils.features.notes.presentation.edit_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.use_case.AddNote
import com.example.universityutils.features.notes.domain.use_case.GetNotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private var addNoteUseCase: AddNote,
    private var getNotesUseCase: GetNotes
) : ViewModel() {

    //View model se deberia encargar de crear la nota, no hacerlo en la view
    fun addNote(note: Note) {
        println("???? vm add note")
        viewModelScope.launch {
            print("???? vm $note")
            addNoteUseCase(note)
        }
    }

    fun getNotes() {
        println("???? vm get notes")
        viewModelScope.launch {
            val notes = getNotesUseCase.invoke()

            notes.forEach { println("$it") }
        }
    }

}