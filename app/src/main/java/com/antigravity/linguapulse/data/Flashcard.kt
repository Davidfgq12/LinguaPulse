package com.antigravity.linguapulse.data

import androidx.room.Entity
import androidx.room.PrimaryKey

object Categories {
    const val DAILY = "DAILY"
    const val B2B_SALES = "B2B_SALES"
}

object Subcategories {
    const val CONNECTOR = "CONNECTOR"
    const val PHRASAL_VERB = "PHRASAL_VERB"
    const val SENTENCE = "SENTENCE"
}

object CardState {
    const val NEW = "NEW"
    const val LEARNING = "LEARNING"
    const val REVIEW = "REVIEW"
    const val MASTERED = "MASTERED"
}

@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val termEn: String,
    val meaningEs: String,
    val explanationEn: String = "",
    val explanationEs: String = "",
    val exampleEn: String = "",
    val exampleEs: String = "",
    val category: String = Categories.DAILY,
    val subcategory: String = Subcategories.CONNECTOR,
    val isCustom: Boolean = false,
    
    // Spaced Repetition fields (SuperMemo-2)
    val repetitions: Int = 0,
    val intervalDays: Int = 0,
    val easeFactor: Float = 2.5f,
    val nextReviewDate: Long = 0L,
    val lastReviewedDate: Long = 0L,
    val state: String = CardState.NEW
)
