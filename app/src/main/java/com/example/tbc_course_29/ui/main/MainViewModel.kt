package com.example.tbc_course_29.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_course_29.common.Resource
import com.example.tbc_course_29.data.remote.service.ApiInterface
import com.example.tbc_course_29.domain.model.UserModel
import com.example.tbc_course_29.domain.use_case.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase:GetUserUseCase): ViewModel() {

    private val _user = MutableStateFlow(Resource<List<UserModel.UserModelItem>>())
    val user = _user.asStateFlow()


    fun getUsers(){
        viewModelScope.launch {
            val response = getUserUseCase.invoke()
            response.collect{
                _user.value = it
            }
        }
    }

}