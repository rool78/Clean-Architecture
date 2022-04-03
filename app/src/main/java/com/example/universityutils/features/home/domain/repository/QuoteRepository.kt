package com.example.universityutils.features.home.domain.repository

import com.example.universityutils.features.home.domain.model.Quote

interface QuoteRepository {

    suspend fun getQuote(id: Int): Quote

    suspend fun getNumberOfQuotes(): Int
}