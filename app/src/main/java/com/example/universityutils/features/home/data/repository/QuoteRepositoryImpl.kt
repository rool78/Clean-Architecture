package com.example.universityutils.features.home.data.repository

import com.example.universityutils.features.home.domain.model.Quote
import com.example.universityutils.features.home.domain.repository.QuoteRepository
import kotlin.random.Random
import kotlin.random.nextInt

class QuoteRepositoryImpl: QuoteRepository {

    private val quoteList = listOf(
        Quote("I'm just learning"),
        Quote("Press again"),
        Quote("What do you think about Compose?"),
        Quote("I don't know what to say"),
        Quote("I'm learning Compose"),
        Quote("I'm a quote and I come from your machine memory, is very dark here. Help")
    )

    override suspend fun getQuote(id: Int): Quote {
        return quoteList[id]
    }

    override suspend fun getNumberOfQuotes(): Int {
        return quoteList.size
    }
}