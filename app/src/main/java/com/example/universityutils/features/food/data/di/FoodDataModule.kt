package com.example.universityutils.features.food.data.di

import com.example.universityutils.App_HiltComponents
import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.data.repository.FoodRepositoryImpl
import com.example.universityutils.features.food.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object FoodDataModule {

    @Provides
    fun provideOpenFoodApi(client: OkHttpClient): OpenFoodApi {
        return Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    fun provideFoodRepository(
        api: OpenFoodApi
    ): FoodRepository {
        return FoodRepositoryImpl(api)
    }

}