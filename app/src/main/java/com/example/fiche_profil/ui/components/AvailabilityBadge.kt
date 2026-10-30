package com.example.fiche_profil.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Composable réutilisable affichant le statut de disponibilité du développeur.
 */
@Composable
fun AvailabilityBadge(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    val statusText = if (isAvailable) "Disponible pour un projet / stage" else "Actuellement en poste"
    val badgeColor = if (isAvailable) Color(0xFF4CAF50) else Color(0xFFFF9800)

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        color = badgeColor.copy(alpha = 0.15f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), // Padding interne
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(badgeColor)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = statusText,
                style = MaterialTheme.typography.labelSmall,
                color = badgeColor,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
