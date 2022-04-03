package com.example.universityutils.features.home.domain.use_case

import com.example.universityutils.features.home.domain.SubjectsRepository
import com.example.universityutils.features.home.domain.model.Subject
import javax.inject.Inject

class SearchSubjects @Inject constructor(private val repository: SubjectsRepository) {

    suspend operator fun invoke(): Result<List<Subject>> {
        return repository.getAllSubjects()
    }

}