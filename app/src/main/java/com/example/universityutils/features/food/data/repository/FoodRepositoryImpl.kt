package com.example.universityutils.features.food.data.repository

import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.domain.model.Food
import com.example.universityutils.features.food.domain.repository.FoodRepository
import com.example.universityutils.features.food.data.remote.dto.Product
import toFood
import kotlin.math.roundToInt

class FoodRepositoryImpl(private val api : OpenFoodApi) : FoodRepository {

    override suspend fun search(
        query: String,
        page: Int,
        pageSize: Int): Result<List<Food>>{
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(searchDto.products.mapNotNull {
                it.toFood()
            })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}