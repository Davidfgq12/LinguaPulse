package com.antigravity.linguapulse.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {

    @Query("SELECT * FROM flashcards ORDER BY id ASC")
    fun getAllCards(): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE category = :category ORDER BY id ASC")
    fun getCardsByCategory(category: String): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE category = :category AND subcategory = :subcategory ORDER BY id ASC")
    fun getCardsByCategoryAndSubcategory(category: String, subcategory: String): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE nextReviewDate <= :currentTime OR state = 'NEW' ORDER BY nextReviewDate ASC")
    fun getDueCards(currentTime: Long): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE category = :category AND (nextReviewDate <= :currentTime OR state = 'NEW') ORDER BY nextReviewDate ASC")
    fun getDueCardsByCategory(category: String, currentTime: Long): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards WHERE id = :id LIMIT 1")
    suspend fun getCardById(id: Long): Flashcard?

    @Query("SELECT * FROM flashcards WHERE state != 'MASTERED' ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomCardForNotification(): Flashcard?

    @Query("SELECT * FROM flashcards ORDER BY RANDOM() LIMIT 1")
    suspend fun getAnyRandomCard(): Flashcard?

    @Query("SELECT COUNT(*) FROM flashcards")
    fun getTotalCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM flashcards WHERE state = 'MASTERED'")
    fun getMasteredCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM flashcards WHERE nextReviewDate <= :currentTime OR state = 'NEW'")
    fun getDueCount(currentTime: Long): Flow<Int>

    @Query("SELECT * FROM flashcards WHERE termEn LIKE '%' || :query || '%' OR meaningEs LIKE '%' || :query || '%'")
    fun searchCards(query: String): Flow<List<Flashcard>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Flashcard): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<Flashcard>)

    @Update
    suspend fun updateCard(card: Flashcard)

    @Delete
    suspend fun deleteCard(card: Flashcard)

    @Query("SELECT COUNT(*) FROM flashcards")
    suspend fun getDirectTotalCount(): Int
}
