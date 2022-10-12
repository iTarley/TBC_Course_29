package com.example.tbc_course_29.domain.repository


import com.example.tbc_course_29.common.Resource
import com.example.tbc_course_29.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserListRepository {
    suspend fun getUsers(): Flow<Resource<List<UserModel.UserModelItem>>>
}