package com.antigravity.linguapulse

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.ContextCompat
import com.antigravity.linguapulse.notifications.NotificationHelper
import com.antigravity.linguapulse.ui.screens.*
import com.antigravity.linguapulse.ui.theme.LinguaPulseTheme
import com.antigravity.linguapulse.util.TtsHelper

enum class Screen(val title: String, val icon: ImageVector) {
    STUDY("Repaso", Icons.Default.School),
    EXPLORE("Explorar", Icons.Default.Search),
    GUIDE("Guía", Icons.Default.MenuBook),
    SETTINGS("Ajustes", Icons.Default.Settings)
}

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var ttsHelper: TtsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ttsHelper = TtsHelper(this)

        handleIncomingIntent(intent)

        setContent {
            LinguaPulseTheme {
                var currentScreen by remember { mutableStateOf(Screen.STUDY) }
                var showAddDialog by remember { mutableStateOf(false) }

                // State collected from ViewModel
                val allCards by viewModel.allCards.collectAsState()
                val dueCards by viewModel.dueCards.collectAsState()
                val totalCount by viewModel.totalCount.collectAsState()
                val masteredCount by viewModel.masteredCount.collectAsState()
                val dueCount by viewModel.dueCount.collectAsState()
                val selectedCategory by viewModel.selectedStudyCategory.collectAsState()
                val intervalHours by viewModel.notificationIntervalHours.collectAsState()
                val deepLinkCard by viewModel.deepLinkCard.collectAsState()

                // Android 13+ Notification Permission Launcher
                val permissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission()
                ) { isGranted ->
                    // Notification permission response handled gracefully
                }

                fun checkAndRequestNotificationPermission() {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        if (ContextCompat.checkSelfPermission(
                                this@MainActivity,
                                Manifest.permission.POST_NOTIFICATIONS
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                    }
                }

                LaunchedEffect(Unit) {
                    checkAndRequestNotificationPermission()
                }

                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = NavigationBarDefaults.Elevation
                        ) {
                            Screen.values().forEach { screen ->
                                val selected = currentScreen == screen
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { currentScreen = screen },
                                    icon = {
                                        Icon(
                                            imageVector = screen.icon,
                                            contentDescription = screen.title
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = screen.title,
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.primary,
                                        selectedTextColor = MaterialTheme.colorScheme.primary,
                                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    when (currentScreen) {
                        Screen.STUDY -> {
                            StudyScreen(
                                dueCards = dueCards,
                                selectedCategory = selectedCategory,
                                onCategoryChange = { viewModel.setSelectedCategory(it) },
                                onRatingSelected = { card, rating ->
                                    viewModel.submitReview(card, rating)
                                },
                                onSpeak = { ttsHelper.speak(it) },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        Screen.EXPLORE -> {
                            ExploreScreen(
                                cards = allCards,
                                onAddCardClick = { showAddDialog = true },
                                onSpeak = { ttsHelper.speak(it) },
                                onDeleteCard = { viewModel.deleteCard(it) },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        Screen.GUIDE -> {
                            GuideScreen(
                                onSpeak = { ttsHelper.speak(it) },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        Screen.SETTINGS -> {
                            SettingsScreen(
                                totalCards = totalCount,
                                masteredCards = masteredCount,
                                dueCardsCount = dueCount,
                                notificationIntervalHours = intervalHours,
                                onIntervalChange = { viewModel.setNotificationInterval(it) },
                                onSendTestNotification = { viewModel.sendTestNotification() },
                                onRequestNotificationPermission = { checkAndRequestNotificationPermission() },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }

                    // Deep link review dialog from notification
                    if (deepLinkCard != null) {
                        CardReviewDialog(
                            card = deepLinkCard!!,
                            onDismiss = { viewModel.clearDeepLinkCard() },
                            onRatingSelected = { card, rating ->
                                viewModel.submitReview(card, rating)
                            },
                            onSpeak = { ttsHelper.speak(it) }
                        )
                    }

                    // Custom card creation modal
                    if (showAddDialog) {
                        AddCardDialog(
                            onDismiss = { showAddDialog = false },
                            onCardAdded = { newCard ->
                                viewModel.insertCustomCard(newCard)
                            }
                        )
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIncomingIntent(intent)
    }

    private fun handleIncomingIntent(intent: Intent?) {
        if (intent == null) return
        val cardId = intent.getLongExtra(NotificationHelper.EXTRA_CARD_ID, -1L)
        if (cardId != -1L) {
            viewModel.loadDeepLinkCard(cardId)
        }
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }
}
