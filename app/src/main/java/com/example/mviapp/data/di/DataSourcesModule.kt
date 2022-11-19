package com.example.mviapp.data.di

import com.example.mviapp.data.LocalUserDataSource
import com.example.mviapp.data.MockedUser
import com.example.mviapp.data.UserDataSource
import com.example.mviapp.data.repo.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {



    @Singleton
    @Provides
    fun provideLocalUserDataSource(): LocalUserDataSource {
        return LocalUserDataSource()
    }

}