package com.example.universityutils.features.food.data.repository

import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.domain.model.Food
import com.example.universityutils.features.food.domain.repository.FoodRepository
import com.plcoding.tracker_data.remote.dto.Product
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

    private fun Product.toFood(): Food? {
        return Food(
            name = productName ?: return null,
            carbsPer100g = nutriments.carbohydrates100g.roundToInt(),
            proteinPer100g = nutriments.proteins100g.roundToInt(),
            fatPer100g = nutriments.fat100g.roundToInt(),
            caloriesPer100g = nutriments.energyKcal100g.roundToInt(),
            imageUrl = imageFrontThumbUrl
        )
    }

}