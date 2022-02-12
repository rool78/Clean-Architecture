package com.example.universityutils.features.food.data.repository

import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.domain.model.Food
import com.example.universityutils.features.food.domain.repository.FoodRepository

class FoodRepositoryImpl(private val api : OpenFoodApi) : FoodRepository {

    override suspend fun search(
        query: String,
        page: Int,
        pageSize: Int) {
        try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            searchDto.products.forEach({
                println("####product->$it")
            })
//            TODO("return list of food mapping products to our domain model")
        } catch (e: Exception) {
            e.printStackTrace()
            print("search fail")
//            Result.failure(e)
        }
    }

}