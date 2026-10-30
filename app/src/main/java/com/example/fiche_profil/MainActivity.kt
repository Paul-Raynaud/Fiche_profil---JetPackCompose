package com.example.fiche_profil

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.example.fiche_profil.model.sampleSeniorProfile
import com.example.fiche_profil.ui.profile.ProfileApp
import com.example.fiche_profil.ui.theme.Fiche_profilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Fiche_profilTheme {
                val context = LocalContext.current
                ProfileApp(
                    profile = sampleSeniorProfile,
                    onContactClick = {
                        Toast.makeText(
                            context,
                            "Action déclenchée : Contacter ${sampleSeniorProfile.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}
