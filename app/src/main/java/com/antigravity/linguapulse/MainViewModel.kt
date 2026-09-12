package com.antigravity.linguapulse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.antigravity.linguapulse.data.CardRepository
import com.antigravity.linguapulse.data.Flashcard
import com.antigravity.linguapulse.notifications.CardNotificationWorker
import com.antigravity.linguapulse.srs.SrsRating
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CardRepository = (application as LinguaPulseApp).repository

    val allCards: StateFlow<List<Flashcard>> = repository.allCards
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val totalCount: StateFlow<Int> = repository.totalCount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val masteredCount: StateFlow<Int> = repository.masteredCount
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val dueCount: StateFlow<Int> = repository.getDueCount()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val selectedStudyCategory = MutableStateFlow("ALL")

    @OptIn(ExperimentalCoroutinesApi::class)
    val dueCards: StateFlow<List<Flashcard>> = selectedStudyCategory
        .flatMapLatest { category ->
            repository.getDueCards(category)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val notificationIntervalHours = MutableStateFlow(4L)
    val deepLinkCard = MutableStateFlow<Flashcard?>(null)

    fun setSelectedCategory(category: String) {
        selectedStudyCategory.value = category
    }

    fun submitReview(card: Flashcard, rating: SrsRating) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.submitReview(card, rating)
        }
    }

    fun insertCustomCard(card: Flashcard) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCard(card)
        }
    }

    fun deleteCard(card: Flashcard) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCard(card)
        }
    }

    fun loadDeepLinkCard(cardId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val card = repository.getCardById(cardId)
            deepLinkCard.value = card
        }
    }

    fun clearDeepLinkCard() {
        deepLinkCard.value = null
    }

    fun setNotificationInterval(hours: Long) {
        notificationIntervalHours.value = hours
        CardNotificationWorker.schedulePeriodic(getApplication(), hours)
    }

    fun sendTestNotification() {
        CardNotificationWorker.triggerImmediate(getApplication())
    }
}
