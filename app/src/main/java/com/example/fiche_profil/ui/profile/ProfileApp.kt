package com.example.fiche_profil.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fiche_profil.model.ProfileData
import com.example.fiche_profil.model.sampleJuniorProfile
import com.example.fiche_profil.model.sampleSeniorProfile
import com.example.fiche_profil.ui.theme.Fiche_profilTheme

/**
 * Composable racine de l'application utilisant Scaffold.
 */
@Composable
fun ProfileApp(
    profile: ProfileData,
    modifier: Modifier = Modifier,
    onContactClick: () -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        // innerPadding est transmis comme padding externe à ProfileScreen
        ProfileScreen(
            profile = profile,
            modifier = Modifier.padding(innerPadding),
            onContactClick = onContactClick
        )
    }
}



@Preview(
    showBackground = true,
    name = "Mode Clair - Profil Junior",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ProfileLightPreview() {
    Fiche_profilTheme(darkTheme = false) {
        ProfileApp(profile = sampleJuniorProfile)
    }
}

@Preview(
    showBackground = true,
    name = "Mode Sombre - Profil Senior",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileDarkPreview() {
    Fiche_profilTheme(darkTheme = true) {
        ProfileApp(profile = sampleSeniorProfile)
    }
}
