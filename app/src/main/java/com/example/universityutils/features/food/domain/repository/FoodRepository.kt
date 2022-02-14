package com.example.universityutils.features.food.domain.repository

import com.example.universityutils.features.food.domain.model.Food

interface FoodRepository {

    suspend fun search(query: String, page: Int, pageSize: Int): Result<List<Food>>

}