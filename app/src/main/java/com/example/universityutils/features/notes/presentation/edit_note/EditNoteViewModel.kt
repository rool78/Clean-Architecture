package com.example.universityutils.features.notes.presentation.edit_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.use_case.AddNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(private val addNoteUseCase: AddNote) : ViewModel() {

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

}