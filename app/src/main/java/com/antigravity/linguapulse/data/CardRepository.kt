package com.antigravity.linguapulse.data

import com.antigravity.linguapulse.srs.SrsEngine
import com.antigravity.linguapulse.srs.SrsRating
import kotlinx.coroutines.flow.Flow

class CardRepository(private val dao: FlashcardDao) {

    val allCards: Flow<List<Flashcard>> = dao.getAllCards()
    val totalCount: Flow<Int> = dao.getTotalCount()
    val masteredCount: Flow<Int> = dao.getMasteredCount()

    fun getCardsByCategory(category: String): Flow<List<Flashcard>> {
        return dao.getCardsByCategory(category)
    }

    fun getCardsByCategoryAndSubcategory(category: String, subcategory: String): Flow<List<Flashcard>> {
        return dao.getCardsByCategoryAndSubcategory(category, subcategory)
    }

    fun getDueCards(category: String? = null, currentTime: Long = System.currentTimeMillis()): Flow<List<Flashcard>> {
        return if (category.isNullOrEmpty() || category == "ALL") {
            dao.getDueCards(currentTime)
        } else {
            dao.getDueCardsByCategory(category, currentTime)
        }
    }

    fun getDueCount(currentTime: Long = System.currentTimeMillis()): Flow<Int> {
        return dao.getDueCount(currentTime)
    }

    fun searchCards(query: String): Flow<List<Flashcard>> {
        return dao.searchCards(query)
    }

    suspend fun getCardById(id: Long): Flashcard? {
        return dao.getCardById(id)
    }

    suspend fun getRandomCardForNotification(): Flashcard? {
        return dao.getRandomCardForNotification() ?: dao.getAnyRandomCard()
    }

    suspend fun submitReview(card: Flashcard, rating: SrsRating) {
        val updatedCard = SrsEngine.processReview(card, rating)
        dao.updateCard(updatedCard)
    }

    suspend fun insertCard(card: Flashcard): Long {
        return dao.insertCard(card)
    }

    suspend fun deleteCard(card: Flashcard) {
        dao.deleteCard(card)
    }

    suspend fun ensureInitialDataLoaded() {
        if (dao.getDirectTotalCount() == 0) {
            dao.insertAll(InitialData.getInitialCards())
        }
    }
}
