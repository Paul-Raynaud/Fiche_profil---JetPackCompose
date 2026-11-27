package com.example.fiche_profil.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Champ de contact réutilisable en LECTURE SEULE (readOnly = true).
 */
@Composable
fun ContactField(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true, // Exigence du sujet : Lecture seule
        label = { Text(text = label) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = label
            )
        },
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}