package com.example.universityutils.features.food.domain.use_case

import com.example.universityutils.features.food.domain.model.Food
import com.example.universityutils.features.food.domain.repository.FoodRepository
import javax.inject.Inject

class SearchFood @Inject constructor(private val repository: FoodRepository) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<Food>> {
        if(query.isBlank()) {
            println("blank query")
        }
        return repository.search(query.trim(), page, pageSize)
    }
}