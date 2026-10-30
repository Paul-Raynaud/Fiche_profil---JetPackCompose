package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.model.ProfileData

/**
 * Écran de profil composant la carte dans un conteneur Box.
 */
@Composable
fun ProfileScreen(
    profile: ProfileData,
    modifier: Modifier = Modifier,
    onContactClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        ProfileCard(
            profile = profile,
            // PADDING EXTERNE : Le parent décide du placement et des marges de la carte
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onContactClick = onContactClick
        )
    }
}
