package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.model.ContactInfo
import com.example.fiche_profil.ui.components.ContactField
import com.example.fiche_profil.ui.components.SectionTitle

/**
 * Section contact gérant un ÉTAT LOCAL d'interface avec rememberSaveable (Exigence du sujet).
 */
@Composable
fun ContactSection(
    contactInfo: ContactInfo,
    modifier: Modifier = Modifier
) {
    // ÉTAT LOCAL D'INTERFACE : Afficher/masquer les détails de contact
    var isContactVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        SectionTitle(title = "Contact & Disponibilité")
        Spacer(modifier = Modifier.height(10.dp))

        // Bouton bascule gérant l'état local
        OutlinedButton(
            onClick = { isContactVisible = !isContactVisible },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = if (isContactVisible) "Masquer les informations de contact" else "Afficher les informations de contact")
        }

        // Affichage conditionnel selon l'état local
        if (isContactVisible) {
            Spacer(modifier = Modifier.height(10.dp))

            ContactField(
                label = "Adresse E-mail",
                value = contactInfo.email,
                icon = Icons.Default.Email
            )

            Spacer(modifier = Modifier.height(8.dp))

            ContactField(
                label = "Localisation",
                value = contactInfo.location,
                icon = Icons.Default.Place
            )

            Spacer(modifier = Modifier.height(8.dp))

            ContactField(
                label = "Statut & Disponibilité",
                value = contactInfo.availability,
                icon = Icons.Default.Info
            )
        }
    }
}