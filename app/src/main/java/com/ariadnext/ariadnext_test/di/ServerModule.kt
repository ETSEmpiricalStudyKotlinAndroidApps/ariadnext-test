package com.ariadnext.ariadnext_test.di


import com.ariadnext.server.data.repository.ServerRepositoryImpl
import com.ariadnext.server.domain.repository.ServerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class ServerModule {

    @Binds
    @Singleton
    abstract fun serverRepository(
        debugPreferenceRepositoryImpl: ServerRepositoryImpl
    ): ServerRepository
}