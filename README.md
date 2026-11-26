# Devoir – Amélioration UI de l'application « Profil développeur »

## 1. Titre du projet
**Application Fiche Profil Développeur Améliorée en Jetpack Compose (Material Design 3)**

## 2. Description courte de l'application
Cette application Android est une évolution de l'interface "Profil développeur". Elle propose un écran complet et réactif présentant l'identité d'un développeur (nom, rôle, description, avatar), ses compétences sous forme de carrousel horizontal, sa liste de projets/expériences sous forme de cartes réutilisables, ses informations de contact structurées en lecture seule, et un bouton d'action principal interactif. L'interface s'adapte automatiquement aux thèmes **Clair** et **Sombre**.

## 3. Liste des composants Compose utilisés
- **`Text`** : Pour les titres, descriptions, rôles, dates et libellés.
- **`Button`** : Pour le bouton d'action principal ("Télécharger le CV" / "Voir le portfolio").
- **`Icon`** : Pour accompagner visuellement les projets (`Icons.Default.Info`), le contact (`Icons.Default.Email`, `Icons.Default.Place`, `Icons.Default.Info`), l'action (`Icons.Default.Email`) et l'avatar (`Icons.Default.Person`).
- **`Box` + `Icon`** : Pour créer le placeholder de l'avatar circulaire.
- **`Card`** : Pour la carte principale de profil et les cartes réutilisables `ProjectCard`.
- **`OutlinedTextField`** : En **lecture seule** (`readOnly = true`) pour afficher de manière structurée l'adresse e-mail, la localisation et le statut/disponibilité.

## 4. Liste des layouts utilisés
- **`Column`** : Pour l'organisation verticale des sections (en-tête, compétences, projets, contact).
- **`Row`** : Pour l'alignement horizontal des icônes et textes dans les cartes et champs.
- **`Box`** : Pour la superposition et le centrage de l'avatar et du conteneur d'écran.
- **`Spacer`** : Pour créer des espaces réguliers et aérer l'interface.
- **`Surface`** : Pour appliquer les couleurs du thème (`surfaceVariant`, `secondaryContainer`) aux badges et cartes.

## 5. Explication de la liste affichée avec `LazyColumn` et `LazyRow`
- **`LazyRow` (Compétences)** : Utilisée dans `SkillsSection` pour afficher la liste des compétences sous la forme d'un carrousel horizontal moderne et réactif.
- **`LazyColumn` (Défilement principal)** : Utilisée dans `ProfileScreen` pour garantir un défilement vertical fluide de l'ensemble de l'écran, ce qui permet à l'interface d'être parfaitement lisible sur tous les formats d'écrans.

## 6. Explication des choix de thème (Material Design 3)
- **Couleurs dynamiques (`MaterialTheme.colorScheme`)** : Utilisation des rôles de couleurs Material 3 (`primary`, `onSurface`, `surfaceVariant`, `secondaryContainer`) assurant un contraste optimal.
- **Support Clair / Sombre (`darkTheme`)** : L'application gère nativement le **Mode Clair** et le **Mode Sombre** via le composable de thème `Fiche_profilTheme`. Deux previews dédiées (`ProfileLightPreview` et `ProfileDarkPreview`) permettent de vérifier ce comportement.
- **Formes (`MaterialTheme.shapes`)** : Utilisation de coins arrondis (`RoundedCornerShape(16.dp)` et `CircleShape`) pour une esthétique moderne.

## 7. Captures et Previews
Les fonctions `@Preview` dans `ProfileApp.kt` génèrent le rendu en temps réel directement dans Android Studio :
- **`ProfileLightPreview`** : Rendu du profil en thème clair.
- **`ProfileDarkPreview`** : Rendu du profil en thème sombre.

## 8. Réponses à la question : « Quelles notions du chapitre Compose UI avez-vous réutilisées dans cette application ? »
Nous avons réutilisé l'ensemble des notions fondamentales du chapitre Compose UI :
1. **Composants fondamentaux & réutilisables** avec passage de paramètres.
2. **Layouts de structure** (`Column`, `Row`, `Box`, `Spacer`, `Surface`).
3. **Listes modernes et optimisées** (`LazyRow` pour les compétences, `LazyColumn` pour l'écran).
4. **Composants interactifs et de saisie en lecture seule** (`Button` et `OutlinedTextField` avec `readOnly = true`).
5. **Chaînage de `Modifier`** pour la taille, les marges et la découpe des composants.
6. **Accessibilité de base** via des descriptions de contenu (`contentDescription`) sur toutes les icônes.
7. **Système de Thème Material 3** avec gestion complète du mode clair et du mode sombre.