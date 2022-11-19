package com.example.mviapp.domain.repo

import com.example.mviapp.data.model.UserDto

interface UserRepository {

    suspend fun fetchUser(): List<UserDto>
}