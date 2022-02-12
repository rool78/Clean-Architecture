package com.example.universityutils.features.food.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.food.domain.use_case.SearchFood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private var searchUseCase: SearchFood
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is My new Food Fragment"
    }
    val text: LiveData<String> = _text

    fun searchFood() {
        viewModelScope.launch {
            searchUseCase("a")
        }
    }

}