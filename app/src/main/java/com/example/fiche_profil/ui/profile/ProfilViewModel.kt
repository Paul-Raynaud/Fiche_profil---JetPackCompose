package com.example.fiche_profil.ui.profile

import androidx.lifecycle.ViewModel
import com.example.fiche_profil.model.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.temporal.TemporalQuery

class ProfilViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun onSearchQueryChange(newQuery: String){
        _uiState.update { currentState ->
            currentState.copy(searchQuery = newQuery)
        }
    }

    fun onToggleFavoriteFilter(){
        _uiState.update { currentState ->
            currentState.copy(showOnlyFavorites = !currentState.showOnlyFavorites)
        }
    }

    fun onToggleFavorite(projectId: String){
        _uiState.update { currentState ->
            val updatedFavorites = currentState.favoriteProjectIds.toMutableSet()
            if (updatedFavorites.contains(projectId)){
                updatedFavorites.remove(projectId)
            }else{
                updatedFavorites.add(projectId)
            }
            currentState.copy(favoriteProjectIds = updatedFavorites)
        }
    }
}