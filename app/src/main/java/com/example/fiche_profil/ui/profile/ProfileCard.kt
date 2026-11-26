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
import com.example.fiche_profil.ui.components.ProjectCard
import com.example.fiche_profil.ui.components.SectionTitle

/**
 * Carte principale affichant le profil complet.
 */
@Composable
fun ProfileCard(
    profile: ProfileData,
    modifier: Modifier = Modifier,
    onContactClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp), // Padding interne
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                description = profile.description,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 1. Liste de compétences (LazyRow)
            SkillsSection(
                skills = profile.skills,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 2. Section Projets & Expériences (ProjectCard)
            SectionTitle(
                title = "Projets & Expériences",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            profile.projects.forEach { project ->
                ProjectCard(project = project)
                Spacer(modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 3. Section Contact (OutlinedTextFields en lecture seule)
            ContactSection(
                contactInfo = profile.contactInfo,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 4. Bouton d'action principal
            ActionButton(
                text = profile.buttonText,
                onClick = onContactClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}