package com.example.universityutils.features.food.domain.use_case

import com.example.universityutils.features.food.domain.repository.FoodRepository
import javax.inject.Inject

class SearchFood @Inject constructor(private val repository: FoodRepository) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ) {
        if(query.isBlank()) {
            print("blank query")
        }
        repository.search(query.trim(), page, pageSize)
    }
}