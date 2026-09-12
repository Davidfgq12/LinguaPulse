package com.antigravity.linguapulse.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.antigravity.linguapulse.data.Flashcard
import com.antigravity.linguapulse.srs.SrsRating
import com.antigravity.linguapulse.ui.components.FlipCardView
import com.antigravity.linguapulse.ui.components.SrsRatingButtons

@Composable
fun CardReviewDialog(
    card: Flashcard,
    onDismiss: () -> Unit,
    onRatingSelected: (Flashcard, SrsRating) -> Unit,
    onSpeak: (String) -> Unit
) {
    var isFlipped by remember { mutableStateOf(false) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🔔 Notificación: Revisar Tarjeta",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Cerrar")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Card View
                FlipCardView(
                    card = card,
                    isFlipped = isFlipped,
                    onFlip = { isFlipped = !isFlipped },
                    onSpeak = onSpeak,
                    modifier = Modifier.height(380.dp)
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Action / Rating Buttons
                if (!isFlipped) {
                    Button(
                        onClick = { isFlipped = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Ver Significado en Español", fontWeight = FontWeight.Bold)
                    }
                } else {
                    SrsRatingButtons(
                        onRatingSelected = { rating ->
                            onRatingSelected(card, rating)
                            onDismiss()
                        }
                    )
                }
            }
        }
    }
}
