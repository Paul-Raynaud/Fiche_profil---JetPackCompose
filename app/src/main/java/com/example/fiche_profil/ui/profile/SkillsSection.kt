package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.ui.components.SectionTitle
import com.example.fiche_profil.ui.components.SkillChip

/**
 * Section affichant la liste des compétences sous forme de badges.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(title = "Compétences")
        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.forEach { skill ->
                SkillChip(skill = skill)
            }
        }
    }
}
