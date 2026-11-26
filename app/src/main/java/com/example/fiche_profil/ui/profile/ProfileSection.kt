package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.model.ContactInfo
import com.example.fiche_profil.ui.components.ContactField
import com.example.fiche_profil.ui.components.SectionTitle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place


@Composable
fun ContactSection(
    contactInfo: ContactInfo,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        SectionTitle(title = "Contact & Disponibilité")
        Spacer(modifier = Modifier.height(10.dp))

        ContactField(
            label = "Adresse mail",
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
            label = "Staut & Disponibilité",
            value = contactInfo.availability,
            icon = Icons.Default.Info
        )
    }
}