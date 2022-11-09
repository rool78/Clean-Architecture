package com.example.universityutils.features.home.data.repository

import com.example.universityutils.features.home.data.SubjectsApi
import com.example.universityutils.features.home.data.dto.SubjectDTO
import com.example.universityutils.features.home.domain.repository.SubjectsRepository
import com.example.universityutils.features.home.domain.model.Subject
import java.lang.Exception
import javax.inject.Inject

class SubjectsRepositoryImpl @Inject constructor(
    private val api: SubjectsApi
): SubjectsRepository {

    override suspend fun getAllSubjects(): Result<List<Subject>> {
        return try {
            val subjects = api.getAllSubjects()
            Result.success(subjects.map {
                it.toSubject()
            })

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    private fun SubjectDTO.toSubject(): Subject {
        return Subject(
            name = name,
            course = course,
            credits = credits,
            type = type,
            semester = semester
        )
    }

}