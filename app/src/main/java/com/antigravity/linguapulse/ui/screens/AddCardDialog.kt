package com.antigravity.linguapulse.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.antigravity.linguapulse.data.Categories
import com.antigravity.linguapulse.data.Flashcard
import com.antigravity.linguapulse.data.Subcategories

@Composable
fun AddCardDialog(
    onDismiss: () -> Unit,
    onCardAdded: (Flashcard) -> Unit
) {
    var termEn by remember { mutableStateOf("") }
    var meaningEs by remember { mutableStateOf("") }
    var explanationEn by remember { mutableStateOf("") }
    var explanationEs by remember { mutableStateOf("") }
    var exampleEn by remember { mutableStateOf("") }
    var exampleEs by remember { mutableStateOf("") }
    var category by remember { mutableStateOf(Categories.DAILY) }
    var subcategory by remember { mutableStateOf(Subcategories.CONNECTOR) }

    val scrollState = rememberScrollState()

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.88f),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "➕ Nueva Tarjeta Personalizada",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                OutlinedTextField(
                    value = termEn,
                    onValueChange = { termEn = it },
                    label = { Text("Término o Frase en Inglés *") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = meaningEs,
                    onValueChange = { meaningEs = it },
                    label = { Text("Significado en Español *") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                // Category Selector
                Text(
                    text = "Categoría Principal:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    FilterChip(
                        selected = category == Categories.DAILY,
                        onClick = { category = Categories.DAILY },
                        label = { Text("Día a Día") },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    FilterChip(
                        selected = category == Categories.B2B_SALES,
                        onClick = { category = Categories.B2B_SALES },
                        label = { Text("Ventas B2B Tech") }
                    )
                }

                // Subcategory Selector
                Text(
                    text = "Tipo de Expresión:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    FilterChip(
                        selected = subcategory == Subcategories.CONNECTOR,
                        onClick = { subcategory = Subcategories.CONNECTOR },
                        label = { Text("Conector") },
                        modifier = Modifier.padding(end = 6.dp)
                    )
                    FilterChip(
                        selected = subcategory == Subcategories.PHRASAL_VERB,
                        onClick = { subcategory = Subcategories.PHRASAL_VERB },
                        label = { Text("Phrasal Verb") },
                        modifier = Modifier.padding(end = 6.dp)
                    )
                    FilterChip(
                        selected = subcategory == Subcategories.SENTENCE,
                        onClick = { subcategory = Subcategories.SENTENCE },
                        label = { Text("Oración") }
                    )
                }

                OutlinedTextField(
                    value = exampleEn,
                    onValueChange = { exampleEn = it },
                    label = { Text("Ejemplo en Inglés (Opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = exampleEs,
                    onValueChange = { exampleEs = it },
                    label = { Text("Traducción del Ejemplo (Opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = explanationEn,
                    onValueChange = { explanationEn = it },
                    label = { Text("Explicación de uso en Inglés (Opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = explanationEs,
                    onValueChange = { explanationEs = it },
                    label = { Text("Explicación de uso en Español (Opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancelar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (termEn.isNotBlank() && meaningEs.isNotBlank()) {
                                val newCard = Flashcard(
                                    termEn = termEn.trim(),
                                    meaningEs = meaningEs.trim(),
                                    explanationEn = explanationEn.trim(),
                                    explanationEs = explanationEs.trim(),
                                    exampleEn = exampleEn.trim(),
                                    exampleEs = exampleEs.trim(),
                                    category = category,
                                    subcategory = subcategory,
                                    isCustom = true
                                )
                                onCardAdded(newCard)
                                onDismiss()
                            }
                        },
                        enabled = termEn.isNotBlank() && meaningEs.isNotBlank()
                    ) {
                        Text("Guardar Tarjeta")
                    }
                }
            }
        }
    }
}
