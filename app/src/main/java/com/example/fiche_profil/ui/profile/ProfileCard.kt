package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.model.ProfileData
import com.example.fiche_profil.ui.components.ActionButton

/**
 * Carte principale affichant le profil complet avec padding interne.
 */
@Composable
fun ProfileCard(
    profile: ProfileData,
    modifier: Modifier = Modifier,
    onContactClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        // PADDING INTERNE : Le composant applique du padding à l'intérieur pour espacer son contenu des bords
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                description = profile.description,
                isAvailable = profile.isAvailable,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            SkillsSection(
                skills = profile.skills,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            ActionButton(
                text = profile.buttonText,
                onClick = onContactClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
