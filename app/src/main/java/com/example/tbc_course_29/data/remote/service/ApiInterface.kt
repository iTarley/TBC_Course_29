package com.example.tbc_course_29.data.remote.service

import com.example.tbc_course_29.domain.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("80d25aee-d9a6-4e9c-b1d1-80d2a7c979bf")
    suspend fun getResponse(): Response<List<UserModel.UserModelItem>>
}