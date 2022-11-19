package com.example.mviapp.presention.state

import com.example.mviapp.domain.model.User

data class MainState(
    val isLoading: Boolean = false,
    val listUser: List<User> =listOf()
)
