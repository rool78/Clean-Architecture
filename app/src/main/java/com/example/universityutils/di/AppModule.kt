package com.example.universityutils.di

import android.content.Context
import androidx.room.Room
import com.example.universityutils.features.food.data.remote.OpenFoodApi
import com.example.universityutils.features.food.data.repository.FoodRepositoryImpl
import com.example.universityutils.features.food.domain.repository.FoodRepository
import com.example.universityutils.features.food.domain.use_case.SearchFood
import com.example.universityutils.features.home.data.SubjectsApi
import com.example.universityutils.features.home.data.SubjectsRepositoryImpl
import com.example.universityutils.features.home.domain.SubjectsRepository
import com.example.universityutils.features.home.domain.use_case.SearchSubjects
import com.example.universityutils.features.notes.data.repository.NotesRepositoryImpl
import com.example.universityutils.features.notes.data.source.NotesDao
import com.example.universityutils.features.notes.data.source.NotesDatabase
import com.example.universityutils.features.notes.domain.repository.NotesRepository
import com.example.universityutils.features.notes.domain.use_case.AddNote
import com.example.universityutils.features.notes.domain.use_case.GetNotes
import com.example.universityutils.features.notes.domain.use_case.NotesUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNotesDatabase(@ApplicationContext applicationContext: Context): NotesDatabase {
        return Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

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

//  subjects

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
    fun provideSubjectUseCase(searchRepository: SubjectsRepository) : SearchSubjects {
        return SearchSubjects(searchRepository)
    }

    @Provides
    fun provideFoodUseCase(foodRepository: FoodRepository) : SearchFood {
        return SearchFood(foodRepository)
    }

    @Provides
    fun provideNotesDao(notesDatabase: NotesDatabase): NotesDao {
        return notesDatabase.notesDao
    }

    @Provides
    fun provideNotesRepository(notesDao: NotesDao): NotesRepository {
        return NotesRepositoryImpl(notesDao)
    }

    @Provides
    fun provideNotesUseCase(notesRepository: NotesRepository): NotesUseCase {
        return NotesUseCase(
            AddNote(notesRepository),
            GetNotes(notesRepository)
        )
    }
}