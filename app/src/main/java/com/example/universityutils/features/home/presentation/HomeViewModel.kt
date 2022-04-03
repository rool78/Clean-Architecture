package com.example.universityutils.features.home.presentation

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.R
import com.example.universityutils.features.home.domain.use_case.SearchSubjects
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchSubjects: SearchSubjects,
    @ApplicationContext private val context: Context) : ViewModel() {

    val homeText = mutableStateOf("")

    init {
        homeText.value = context.getString(R.string.app_name)
    }

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