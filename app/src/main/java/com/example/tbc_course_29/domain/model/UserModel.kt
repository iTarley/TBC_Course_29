package com.example.tbc_course_29.domain.model

import com.squareup.moshi.Json

class UserModel : ArrayList<UserModel.UserModelItem>(){
    data class UserModelItem(
        val id: Int?,
        val email: String?,
        @Json(name = "first_name" )
        val firstName: String?,
        @Json(name = "last_name" )
        val lastName: String?,
        val avatar: String?,
        @Json(name = "message_type" )
        val messageType: String?,
        @Json(name = "last_message" )
        val lastMessage: String?,
        @Json(name = "unrea_message" )
        val unreadMessage: Int?,
        @Json(name = "is_typing" )
        val isTyping: Boolean?,
        @Json(name = "updated_date" )
        val updatedDate: Long?
    )
}