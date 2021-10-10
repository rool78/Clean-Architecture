package com.example.universityutils.features.notes.presentation.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.notes.domain.model.Note
import com.example.universityutils.features.notes.domain.use_case.NotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private var notesUseCase: NotesUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notes Fragment"
    }
    val text: LiveData<String> = _text
    val notesModel = MutableLiveData<List<Note>>()

    fun getNotes() {
        viewModelScope.launch {
            val notes = notesUseCase.getNotes.invoke()
            notesModel.postValue(notes)
        }

    }
}