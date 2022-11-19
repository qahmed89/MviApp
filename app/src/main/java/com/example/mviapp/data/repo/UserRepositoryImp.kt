package com.example.mviapp.data.repo

import com.example.mviapp.data.LocalUserDataSource
import com.example.mviapp.data.UserDataSource
import com.example.mviapp.data.model.UserDto
import com.example.mviapp.domain.repo.UserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override suspend fun fetchUser(): List<UserDto> {
        return localUserDataSource.fetchUser()
    }
}