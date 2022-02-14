package com.example.universityutils.features.food.data.mapper

import com.example.universityutils.features.food.domain.model.Food
import com.plcoding.tracker_data.remote.dto.Product
import kotlin.math.roundToInt

//TODO use it when searching food
class FoodMapper {

    fun Product.toFood(): Food? {
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