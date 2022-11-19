package com.example.mviapp.presention

sealed interface Effect {
    data class ShowSnackBarErrorMessage(val message: String) : Effect
    data class NavigateToDetailsScreen(val route: String) : Effect
}