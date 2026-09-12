package com.antigravity.linguapulse.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antigravity.linguapulse.srs.SrsRating
import com.antigravity.linguapulse.ui.theme.*

@Composable
fun SrsRatingButtons(
    onRatingSelected: (SrsRating) -> Unit,
    modifier: Modifier = Modifier
) {
    val dark = isSystemInDarkTheme()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Button AGAIN / Aún no
        Button(
            onClick = { onRatingSelected(SrsRating.AGAIN) },
            modifier = Modifier
                .weight(1f)
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (dark) SrsAgainBgDark else SrsAgainBg,
                contentColor = SrsAgainColor
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Repetir",
                    tint = SrsAgainColor,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Aún no",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = SrsAgainColor
                )
            }
        }

        // Button GOOD / La sé
        Button(
            onClick = { onRatingSelected(SrsRating.GOOD) },
            modifier = Modifier
                .weight(1f)
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (dark) SrsGoodBgDark else SrsGoodBg,
                contentColor = SrsGoodColor
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Bien",
                    tint = SrsGoodColor,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Bien",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = SrsGoodColor
                )
            }
        }

        // Button EASY / Fácil
        Button(
            onClick = { onRatingSelected(SrsRating.EASY) },
            modifier = Modifier
                .weight(1f)
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (dark) SrsEasyBgDark else SrsEasyBg,
                contentColor = SrsEasyColor
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Fácil",
                    tint = SrsEasyColor,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Fácil",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = SrsEasyColor
                )
            }
        }
    }
}
