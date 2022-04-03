package com.example.universityutils.features.home.domain.use_case

import com.example.universityutils.features.home.domain.model.Quote
import com.example.universityutils.features.home.domain.repository.QuoteRepository
import javax.inject.Inject
import kotlin.random.Random

class GetRandomQuote @Inject constructor(private val quoteRepository: QuoteRepository) {

    suspend operator fun invoke(): Quote =
        quoteRepository.getQuote(
            Random.nextInt(0, quoteRepository.getNumberOfQuotes() - 1)
        )

}