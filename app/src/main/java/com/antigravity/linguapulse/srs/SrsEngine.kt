package com.antigravity.linguapulse.srs

import com.antigravity.linguapulse.data.CardState
import com.antigravity.linguapulse.data.Flashcard
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

enum class SrsRating {
    AGAIN, // No me la sé / Difícil
    GOOD,  // Bien / La sé
    EASY   // Fácil / Dominada
}

object SrsEngine {

    private const val ONE_DAY_MS = 24 * 60 * 60 * 1000L

    fun processReview(card: Flashcard, rating: SrsRating, now: Long = System.currentTimeMillis()): Flashcard {
        var reps = card.repetitions
        var ef = card.easeFactor
        var interval = card.intervalDays
        var newState = card.state

        when (rating) {
            SrsRating.AGAIN -> {
                reps = 0
                interval = 1
                ef = max(1.3f, ef - 0.2f)
                newState = CardState.LEARNING
            }
            SrsRating.GOOD -> {
                reps += 1
                interval = when (reps) {
                    1 -> 1
                    2 -> 4
                    else -> max(1, (interval * ef).roundToInt())
                }
                // Ease factor slight adjustment according to SM-2 formula for score 3
                ef = max(1.3f, min(3.0f, ef - 0.05f))
                newState = if (reps >= 4) CardState.MASTERED else CardState.REVIEW
            }
            SrsRating.EASY -> {
                reps += 1
                interval = when (reps) {
                    1 -> 2
                    2 -> 6
                    else -> max(2, (interval * ef * 1.3f).roundToInt())
                }
                ef = min(3.0f, ef + 0.15f)
                newState = if (reps >= 3) CardState.MASTERED else CardState.REVIEW
            }
        }

        val nextReview = now + (interval * ONE_DAY_MS)

        return card.copy(
            repetitions = reps,
            intervalDays = interval,
            easeFactor = ef,
            nextReviewDate = nextReview,
            lastReviewedDate = now,
            state = newState
        )
    }
}
