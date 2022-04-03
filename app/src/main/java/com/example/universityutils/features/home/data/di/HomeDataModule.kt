package com.example.universityutils.features.home.data.di

import com.example.universityutils.features.home.data.SubjectsApi
import com.example.universityutils.features.home.data.SubjectsRepositoryImpl
import com.example.universityutils.features.home.data.repository.QuoteRepositoryImpl
import com.example.universityutils.features.home.domain.repository.QuoteRepository
import com.example.universityutils.features.home.domain.repository.SubjectsRepository
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
object HomeDataModule {

    @Provides
    fun provideSubjectsApi(client: OkHttpClient): SubjectsApi {
        return Retrofit.Builder()
            .baseUrl(SubjectsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    fun provideSubjectsRepository(
        api: SubjectsApi
    ): SubjectsRepository {
        return SubjectsRepositoryImpl(api)
    }

    @Provides
    fun provideQuoteRepository(): QuoteRepository = QuoteRepositoryImpl()

}
