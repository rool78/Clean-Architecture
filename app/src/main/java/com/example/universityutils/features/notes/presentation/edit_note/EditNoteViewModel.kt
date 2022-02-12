package com.example.universityutils.features.notes.presentation.edit_note

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.use_case.AddNote
import com.example.universityutils.features.notes.domain.use_case.GetNotes
import com.example.universityutils.features.notes.domain.use_case.NotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(private var notesUseCase: NotesUseCase) : ViewModel() {

//    private val _noteTitle = mutableStateOf()

    //???? View model se deberia encargar de crear la nota, no hacerlo en la view
    fun addNote(note: Note) {
        viewModelScope.launch {
            notesUseCase.addNote(note)
        }
    }

}