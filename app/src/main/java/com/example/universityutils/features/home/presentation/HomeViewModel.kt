package com.example.universityutils.features.home.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.home.domain.use_case.GetRandomQuote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomQuote: GetRandomQuote) : ViewModel() {

    val homeText = mutableStateOf("")

    fun getQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            homeText.value = getRandomQuote().quote
        }
    }
}