package com.example.tbc_course_29.data.repository


import com.example.tbc_course_29.common.RequestHandler
import com.example.tbc_course_29.common.Resource
import com.example.tbc_course_29.data.remote.service.ApiInterface
import com.example.tbc_course_29.domain.repository.UserListRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(private val api: ApiInterface) :
    RequestHandler(), UserListRepository {

    override suspend fun getUsers() = flow {
        emit(Resource.loading())
        emit(apiCall { api.getResponse() })
    }
}