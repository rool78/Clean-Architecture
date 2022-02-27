package com.example.universityutils.features.home.data.dto

import com.squareup.moshi.Json

data class SubjectDTO(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "course")
    val course: Int,
    @field:Json(name = "semester")
    val semester: Int,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "credits")
    val credits: Int
    )