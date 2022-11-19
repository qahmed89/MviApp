package com.example.mviapp.data

import com.example.mviapp.data.model.UserDto

class LocalUserDataSource : UserDataSource {
    override suspend fun fetchUser(): List<UserDto> = MockedUser.user
}