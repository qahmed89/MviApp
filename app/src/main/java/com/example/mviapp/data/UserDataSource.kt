package com.example.mviapp.data

import com.example.mviapp.data.model.UserDto

interface UserDataSource {

    suspend fun fetchUser(): List<UserDto>
}