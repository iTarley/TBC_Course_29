package com.example.tbc_course_29.di

import com.example.tbc_course_29.data.repository.UserListRepositoryImpl
import com.example.tbc_course_29.domain.repository.UserListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        userListRepositoryImpl: UserListRepositoryImpl
    ): UserListRepository
}