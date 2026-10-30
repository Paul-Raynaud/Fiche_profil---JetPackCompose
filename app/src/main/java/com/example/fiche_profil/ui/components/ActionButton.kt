package com.example.fiche_profil.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Composable réutilisable pour un bouton d'action personnalisé avec chaînage et accessibilité.
 */
@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .semantics {
                // Accessibilité : indique aux lecteurs d'écran (TalkBack) qu'il s'agit d'un bouton
                role = Role.Button
                contentDescription = "Bouton d'action : $text"
            },
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 16.dp), // Padding interne
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
