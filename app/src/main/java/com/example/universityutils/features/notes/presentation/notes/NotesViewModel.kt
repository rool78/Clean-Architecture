package com.example.universityutils.features.notes.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.notes.domain.use_case.GetNotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val getNotesUseCase: GetNotes) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = getNotesUseCase.invoke()
            state.value.notes = notes
        }
    }
}