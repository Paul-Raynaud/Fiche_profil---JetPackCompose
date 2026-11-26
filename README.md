# Profil développeur Compose

> [!NOTE]
> **Devoir 2 (Amélioration UI)** : La version améliorée de l'application avec Material 3, `LazyRow`, `LazyColumn` et `OutlinedTextField` se trouve sur la branche **`Devoir-Amélioration_UI_application`**.

## Présentation de l'Application

Cette application Android développée en **Jetpack Compose** (Material 3) affiche une fiche de profil développeur moderne, claire et adaptative. L'application met en avant les informations clés d'un professionnel ou d'un étudiant en informatique à travers une interface fluide et structurée.

### Fonctionnalités de l'interface :
- **Avatar dynamique** : Affiche l'initiale du développeur dans un cercle coloré Material 3 (`ProfileAvatar`).
- **En-tête professionnel** : Affiche le nom, le poste/titre professionnel et une courte présentation.
- **Indicateur de statut** : Un badge coloré dynamique (`AvailabilityBadge`) indiquant si le profil est *Disponible pour un projet / stage* (voyant vert) ou *Actuellement en poste* (voyant orange).
- **Mosaïque de compétences** : Une liste de compétences présentées sous forme de badges individuels (`SkillChip`) organisés en flux automatique (`FlowRow`).
- **Zone d'action interactive** : Un bouton d'action sur-mesure (`ActionButton`) permettant de contacter le développeur ou de consulter son portfolio, déclenchant une notification visuelle (`Toast`).

---

## Architecture du Projet & Découpage des Composants

L'application adopte les principes de l'**Atomic Design** et une architecture modulaire propre, organisée en packages distincts :

```
com.example.fiche_profil/
├── MainActivity.kt                         # Point d'entrée principal de l'activité
├── model/
│   └── ProfileData.kt                      # Modèle de données et profils de démonstration
└── ui/
    ├── components/                         # Composants atomiques réutilisables
    │   ├── ActionButton.kt                 # Bouton d'action réutilisable avec accessibilité
    │   ├── AvailabilityBadge.kt            # Badge de statut de disponibilité
    │   ├── ProfileAvatar.kt                # Avatar circulaire réutilisable
    │   ├── SectionTitle.kt                 # Titre de section typographié
    │   └── SkillChip.kt                    # Badge individuel de compétence
    └── profile/                            # Composants d'assemblage et écran
        ├── ProfileApp.kt                   # Composable racine avec Scaffold & Previews
        ├── ProfileCard.kt                  # Carte d'affichage du profil avec élévation
        ├── ProfileHeader.kt                # Assemblage de l'en-tête (Avatar, Nom, Rôle, Statut)
        ├── ProfileScreen.kt                # Conteneur principal gérant le placement et l'arrière-plan
        └── SkillsSection.kt                # Assemblage de la section des compétences
```

### Rôle des Composants :

1. **`ProfileAvatar`** : Génère un badge circulaire avec l'initiale majuscule du nom transmis.
2. **`SectionTitle`** : Standardise la typographie des titres de sections (`titleMedium` en gras).
3. **`AvailabilityBadge`** : Calcule dynamiquement la couleur et le libellé du statut selon la disponibilité du profil.
4. **`SkillChip`** : Reçoit le nom d'une compétence et lui applique un fond `secondaryContainer` aéré.
5. **`ActionButton`** : Bouton personnalisé combinant le chaînage de modifiers (`fillMaxWidth`, `clip`, `clickable`) et la déclaration sémantique d'accessibilité (`Role.Button`).
6. **`SkillsSection`** : Organise les `SkillChip` dans un assemblage réactif avec `FlowRow`.
7. **`ProfileHeader`** : Regroupe l'avatar, le nom, le rôle, le badge et la bio en un bloc vertical centré.
8. **`ProfileCard`** : Reçoit l'objet `ProfileData` et applique une carte Material 3 (`Card`) avec un ombre de `6.dp`.
9. **`ProfileScreen`** : Centre la carte dans un conteneur `Box` occupant tout l'écran (`fillMaxSize`).
10. **`ProfileApp`** : Intègre le tout dans un `Scaffold` pour s'adapter parfaitement aux insets système (*Edge-to-Edge*).

---

## Concepts Techniques Mis en Œuvre

- **Distinction Padding Externe vs Padding Interne** :
  - **Padding externe** : Appliqué par le composant parent pour positionner un élément par rapport à son environnement (ex. `Modifier.padding(innerPadding)` fourni par `Scaffold`, et `Modifier.padding(16.dp)` autour de `ProfileCard`).
  - **Padding interne** : Appliqué à l'intérieur du composant pour espacer son propre contenu des bordures de son conteneur (ex. `Modifier.padding(20.dp)` dans `ProfileCard`, `padding(horizontal = 10.dp, vertical = 6.dp)` dans `SkillChip`).
- **Discipline des Modifiers** : Chaque composable réutilisable accepte par défaut le paramètre `modifier: Modifier = Modifier` qu'il applique sur son conteneur racine.
- **Callbacks et Événements** : Les actions utilisateur sont transmises sous forme de lambdas (`onClick: () -> Unit`), permettant de séparer l'interface de la logique applicative.
- **Accessibilité** : Utilisation du modifier `.semantics { role = Role.Button; contentDescription = "..." }` pour garantir la compatibilité avec les lecteurs d'écran (TalkBack).

---

## Previews et Variantes de Profils

L'application inclut deux fonctions de prévisualisation dans `ProfileApp.kt` permettant de tester différentes variantes d'interfaces directement dans Android Studio :

- **`ProfileJuniorPreview`** : Affiche le profil d'un *Développeur Android Junior* à la recherche d'un stage (statut disponible / voyant vert).
- **`ProfileSeniorPreview`** : Affiche le profil d'une *Développeuse Fullstack Mobile* expérimentée (statut en poste / voyant orange).

---

## Lancement du Projet

1. Ouvrez le projet dans **Android Studio**.
2. Attendez la fin de la synchronisation Gradle.
3. Pour afficher l'interface sans émulateur, ouvrez le fichier `ProfileApp.kt` et cliquez sur l'onglet **Split** ou **Design** (en haut à droite) pour afficher les **Previews**.
4. Pour exécuter l'application sur un émulateur ou un appareil physique, cliquez sur le bouton **Run 'app'** (Flèche verte).
