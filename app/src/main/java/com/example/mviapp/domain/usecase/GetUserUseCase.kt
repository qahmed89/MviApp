package com.example.mviapp.domain.usecase

import com.example.mviapp.domain.model.User
import com.example.mviapp.domain.model.toUser
import com.example.mviapp.domain.repo.UserRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
    ) {

    suspend operator fun invoke(
    ): List<User> {
        return repository.fetchUser().map { it.toUser() }
    }
}