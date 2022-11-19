package com.example.mviapp.domain.di

import com.example.mviapp.domain.repo.UserRepository
import com.example.mviapp.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {


    @Singleton
    @Provides
    fun provideGetUserUseCase(
     userRepository: UserRepository
    ): GetUserUseCase = GetUserUseCase(repository = userRepository)

}
