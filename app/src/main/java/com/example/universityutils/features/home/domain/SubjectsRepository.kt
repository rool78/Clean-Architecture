package com.example.universityutils.features.home.domain

import com.example.universityutils.features.home.domain.model.Subject

interface SubjectsRepository {

    suspend fun getAllSubjects(): Result<List<Subject>>

}