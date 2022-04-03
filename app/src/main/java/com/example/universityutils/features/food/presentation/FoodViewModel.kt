package com.example.universityutils.features.food.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universityutils.features.food.domain.model.Food
import com.example.universityutils.features.food.domain.use_case.SearchFood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val searchUseCase: SearchFood
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is My new Food Fragment"
    }
    val text: LiveData<String> = _text
    val food  = MutableLiveData<List<Food>>()

    fun searchFood(query: String) {
        viewModelScope.launch {
            searchUseCase(query)
                .onSuccess {
                    food.postValue(it)
                }
                .onFailure {
                    print("failure")
                    //todo send event
                }
        }
    }

}