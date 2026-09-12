package com.antigravity.linguapulse.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antigravity.linguapulse.data.CardState
import com.antigravity.linguapulse.data.Categories
import com.antigravity.linguapulse.data.Flashcard
import com.antigravity.linguapulse.data.Subcategories
import com.antigravity.linguapulse.ui.components.FilterChipItem
import com.antigravity.linguapulse.ui.theme.TagB2B
import com.antigravity.linguapulse.ui.theme.TagDaily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    cards: List<Flashcard>,
    onAddCardClick: () -> Unit,
    onSpeak: (String) -> Unit,
    onDeleteCard: (Flashcard) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("ALL") }
    var selectedSubcategory by remember { mutableStateOf("ALL") }

    val filteredCards = remember(cards, searchQuery, selectedCategory, selectedSubcategory) {
        cards.filter { card ->
            val matchesCategory = selectedCategory == "ALL" || card.category == selectedCategory
            val matchesSubcategory = selectedSubcategory == "ALL" || card.subcategory == selectedSubcategory
            val matchesQuery = searchQuery.isBlank() ||
                    card.termEn.contains(searchQuery, ignoreCase = true) ||
                    card.meaningEs.contains(searchQuery, ignoreCase = true) ||
                    card.explanationEn.contains(searchQuery, ignoreCase = true) ||
                    card.explanationEs.contains(searchQuery, ignoreCase = true)

            matchesCategory && matchesSubcategory && matchesQuery
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddCardClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Añadir Tarjeta")
            }
        },
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Header & Search
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📚 Explorador de Expresiones",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Buscar palabra, conector o significado...") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        trailingIcon = {
                            if (searchQuery.isNotBlank()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                                }
                            }
                        },
                        shape = RoundedCornerShape(14.dp),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Category Chips
                    Row(modifier = Modifier.fillMaxWidth()) {
                        FilterChipItem(
                            selected = selectedCategory == "ALL",
                            label = "Todas",
                            onClick = { selectedCategory = "ALL" }
                        )
                        FilterChipItem(
                            selected = selectedCategory == Categories.DAILY,
                            label = "Día a Día",
                            onClick = { selectedCategory = Categories.DAILY }
                        )
                        FilterChipItem(
                            selected = selectedCategory == Categories.B2B_SALES,
                            label = "Ventas B2B Tech",
                            onClick = { selectedCategory = Categories.B2B_SALES }
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Subcategory Chips
                    Row(modifier = Modifier.fillMaxWidth()) {
                        FilterChipItem(
                            selected = selectedSubcategory == "ALL",
                            label = "Todos los tipos",
                            onClick = { selectedSubcategory = "ALL" }
                        )
                        FilterChipItem(
                            selected = selectedSubcategory == Subcategories.CONNECTOR,
                            label = "Conectores",
                            onClick = { selectedSubcategory = Subcategories.CONNECTOR }
                        )
                        FilterChipItem(
                            selected = selectedSubcategory == Subcategories.PHRASAL_VERB,
                            label = "Phrasal Verbs",
                            onClick = { selectedSubcategory = Subcategories.PHRASAL_VERB }
                        )
                        FilterChipItem(
                            selected = selectedSubcategory == Subcategories.SENTENCE,
                            label = "Oraciones",
                            onClick = { selectedSubcategory = Subcategories.SENTENCE }
                        )
                    }
                }
            }

            // Results count
            Text(
                text = "${filteredCards.size} expresiones encontradas",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Cards List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(filteredCards, key = { it.id }) { card ->
                    CardListItem(
                        card = card,
                        onSpeak = onSpeak,
                        onDeleteCard = if (card.isCustom) onDeleteCard else null
                    )
                }
            }
        }
    }
}

@Composable
private fun CardListItem(
    card: Flashcard,
    onSpeak: (String) -> Unit,
    onDeleteCard: ((Flashcard) -> Unit)?
) {
    var expanded by remember { mutableStateOf(false) }
    val isB2b = card.category == Categories.B2B_SALES

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (isB2b) TagB2B.copy(alpha = 0.15f) else TagDaily.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = if (isB2b) "B2B Tech" else "Día a Día",
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isB2b) TagB2B else TagDaily
                            )
                        }

                        Spacer(modifier = Modifier.width(6.dp))

                        val stateColor = when (card.state) {
                            CardState.MASTERED -> Color(0xFF10B981)
                            CardState.LEARNING, CardState.REVIEW -> Color(0xFF2563EB)
                            else -> Color(0xFF94A3B8)
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = stateColor.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = card.state,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = stateColor
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = card.termEn,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = card.meaningEs,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }

                IconButton(onClick = { onSpeak(card.termEn) }, modifier = Modifier.size(36.dp)) {
                    Icon(
                        Icons.Default.VolumeUp,
                        contentDescription = "Pronunciar",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (onDeleteCard != null) {
                    IconButton(onClick = { onDeleteCard(card) }, modifier = Modifier.size(36.dp)) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Eliminar personalizada",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 10.dp)) {
                    Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                    Spacer(modifier = Modifier.height(8.dp))

                    if (card.explanationEn.isNotBlank()) {
                        Text(
                            text = "Matiz en Inglés:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = card.explanationEn,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                    if (card.explanationEs.isNotBlank()) {
                        Text(
                            text = "Explicación en Español:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = card.explanationEs,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                    if (card.exampleEn.isNotBlank()) {
                        Text(
                            text = "Ejemplo en Contexto:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF10B981)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "“${card.exampleEn}”",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { onSpeak(card.exampleEn) }, modifier = Modifier.size(28.dp)) {
                                Icon(Icons.Default.VolumeUp, contentDescription = null, modifier = Modifier.size(16.dp))
                            }
                        }
                        if (card.exampleEs.isNotBlank()) {
                            Text(
                                text = "➔ ${card.exampleEs}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }
                    }
                }
            }
        }
    }
}
