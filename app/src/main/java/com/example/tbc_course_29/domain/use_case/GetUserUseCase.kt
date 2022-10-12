package com.example.tbc_course_29.domain.use_case

import com.example.tbc_course_29.domain.repository.UserListRepository
import javax.inject.Inject

class GetUserUseCase@Inject constructor(private val userListRepository: UserListRepository)  {

    suspend fun invoke() = userListRepository.getUsers()
}