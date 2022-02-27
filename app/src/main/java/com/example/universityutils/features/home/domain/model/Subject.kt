package com.example.universityutils.features.home.domain.model

data class Subject(
    val name: String,
    val course: Int,
    val semester: Int,
    val type: String,
    val credits: Int
    )