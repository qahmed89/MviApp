package com.example.mviapp.domain.di

import com.example.mviapp.data.LocalUserDataSource
import com.example.mviapp.data.UserDataSource
import com.example.mviapp.data.repo.UserRepositoryImp
import com.example.mviapp.domain.repo.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userDataSource: LocalUserDataSource
    ): UserRepository = UserRepositoryImp(userDataSource)
}
