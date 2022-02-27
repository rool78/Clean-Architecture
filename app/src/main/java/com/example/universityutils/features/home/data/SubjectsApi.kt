package com.example.universityutils.features.home.data

import com.example.universityutils.features.home.data.dto.SubjectDTO
import retrofit2.http.GET

interface SubjectsApi {

    @GET("subjects.json")
    suspend fun getAllSubjects(): List<SubjectDTO>

    companion object {
        const val BASE_URL = "https://university-utils-default-rtdb.europe-west1.firebasedatabase.app/"
    }
}