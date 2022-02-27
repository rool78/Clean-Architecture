package com.example.universityutils.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.home.domain.use_case.SearchSubjects
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var searchSubjects: SearchSubjects) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun searchSubjects() {
        viewModelScope.launch {
            val test = searchSubjects.invoke()
            test.onSuccess {
                println("#### success")
                for (i in it) {
                    println(i)
                }
            }.onFailure {
                println("#### failure")
            }
        }
    }
}