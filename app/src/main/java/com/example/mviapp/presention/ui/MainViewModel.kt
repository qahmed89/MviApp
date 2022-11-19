package com.example.mviapp.presention.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mviapp.domain.model.User
import com.example.mviapp.domain.usecase.GetUserUseCase
import com.example.mviapp.presention.Effect
import com.example.mviapp.presention.Event
import com.example.mviapp.presention.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.internal.ChannelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: GetUserUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(MainState())
    val uiState = _uiState.asStateFlow()
    private var _effect = MutableSharedFlow<Effect>()
    val effect = _effect.asSharedFlow()


    fun onIntent(event: Event) {
        viewModelScope.launch {
            try {
                when (event) {

                    is Event.fetchUser -> {
                        fetchUser()

                    }
                    Event.Navigate -> {
                        _effect.emit(Effect.NavigateToDetailsScreen("Details"))
                    }
                    Event.RequestThrownException -> {
                        throw Exception("Error")
                    }
                    Event.Retry -> {
                        fetchUser()
                    }
                }

            } catch (e: Exception) {
                _effect.emit(Effect.ShowSnackBarErrorMessage(e.message!!))
            }
        }
    }

    private suspend fun fetchUser() {
        val x = useCase()
        _uiState.update {
            it.copy(listUser = x)
        }
    }
}