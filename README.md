# Devoir 3 – Portfolio Développeur Interactif

## 1. Titre du projet
**Application Portfolio Développeur Interactif et Réactif avec Jetpack Compose, ViewModel & StateFlow**

## 2. Description de l'application
Cette application est une évolution de l'interface "Profil développeur". Elle transforme la fiche statique en un **portfolio interactif et réactif**. L'utilisateur peut désormais :
- Rechercher un projet par son **titre** ou une **technologie** utilisée.
- Marquer/retirer un projet des **favoris** en cliquant sur l'icône de cœur.
- Filtrer la liste pour n'afficher que les **projets favoris**.
- Consulter en temps réel le **nombre de projets affichés**.
- Afficher ou masquer les **informations de contact** grâce à une zone dépliable interactive.

---

## 3. États gérés par l'application
L'état principal de l'écran est regroupé dans la classe `ProfileUiState` :
- **`searchQuery`** : Le texte saisi dans la barre de recherche.
- **`showOnlyFavorites`** : L'état du filtre (*true* = uniquement les favoris, *false* = tous les projets).
- **`favoriteProjectIds`** : L'ensemble (`Set<String>`) des identifiants des projets marqués comme favoris.
- **`filteredProjects`** : Propriété calculée filtrant dynamiquement les projets en temps réel selon la recherche et le filtre favoris.
- **`visibleProjectsCount`** : Nombre de projets actuellement affichés.

---

## 4. État local (`rememberSaveable`)
- **Quel état est conservé directement dans un composable et pourquoi ?**  
  Dans le composable `ContactSection`, nous avons conservé l'état **`isContactVisible`** avec `rememberSaveable { mutableStateOf(false) }`.  
  *Pourquoi ?* Cet état gère uniquement l'affichage/masquage local du bloc de contact. Comme il s'agit d'un pur détail d'affichage d'interface qui n'impacte pas le reste des données de l'application, il est préférable de le garder local au composable plutôt que d'encombrer le ViewModel.

---

## 5. State Hoisting
- **Pourquoi votre composable d'écran principal peut-il être considéré comme `stateless` ?**  
  `ProfileScreen` ne stocke ni ne modifie aucun état lui-même. Il reçoit toutes ses valeurs sous forme de paramètres (`uiState`) et délègue toutes les actions de l'utilisateur vers le haut via des callbacks (`onSearchQueryChange`, `onToggleFavoriteFilter`, `onFavoriteClick`). Il est donc 100% prévisualisable et réutilisable.

---

## 6. ViewModel (`ProfilViewModel`)
- **Quel est le rôle de votre ViewModel dans cette application ?**  
  `ProfilViewModel` centralise toute la logique métier et la gestion de l'état de l'écran. Il conserve l'état modifiable privé (`_uiState = MutableStateFlow(...)`), traite les événements de l'utilisateur (saisie de recherche, clic favori, filtre) et met à jour l'état UI de façon thread-safe.

---

## 7. StateFlow
- **Comment l'interface est-elle informée lorsqu'un état change ?**  
  `ProfilViewModel` expose l'état sous forme d'un `StateFlow<ProfileUiState>` immuable et public (`uiState`). Le composable `ProfileContainer` observe ce flux en temps réel via `val uiState by viewModel.uiState.collectAsState()`. À chaque modification émise par le `StateFlow`, Compose re-compose automatiquement l'interface pour afficher les données à jour.

---

## 8. Organisation du code
- **`ProfilViewModel`** : Gère la logique applicative et publie le `StateFlow`.
- **`ProfileUiState`** : Data class représentant l'état complet de l'interface et le filtrage réactif.
- **`ProfileContainer`** : Connecte le ViewModel à Compose (collecte du StateFlow et transmission des callbacks).
- **`ProfileScreen`** : Écran principal stateless avec la barre de recherche, le filtre favoris et le compteur.
- **`ProjectCard`** : Carte réutilisable affichant un projet avec l'icône de cœur favori réactive.
- **`ContactSection`** : Section contact gérant son état local dépliable (`rememberSaveable`).
- **`ActionButton`** : Bouton principal interactif Material 3.

---

## 9. Captures d'écran et Previews
Les fonctions `@Preview` dans `ProfileApp.kt` présentent deux états différents de l'écran :
- **`ProfilePreview1`** : Recherche vide, tous les projets affichés, aucun favori (Mode Clair).
- **`ProfilePreview2`** : Recherche active, filtre favoris activé et plusieurs favoris sélectionnés (Mode Sombre).