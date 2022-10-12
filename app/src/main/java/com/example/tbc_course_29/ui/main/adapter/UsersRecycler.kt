package com.example.tbc_course_29.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_29.R
import com.example.tbc_course_29.databinding.UserItemBinding
import com.example.tbc_course_29.domain.model.UserModel
import com.example.tbc_course_29.extensions.setImage
import java.text.SimpleDateFormat
import java.util.Calendar


class UsersRecycler :
    ListAdapter<UserModel.UserModelItem, UsersRecycler.ViewHolder>(DiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var activeUser: UserModel.UserModelItem


        fun bind() {
            activeUser = getItem(adapterPosition)

            binding.apply {
                imageUser.setImage(activeUser.avatar!!)
                name.text = activeUser.firstName + " " + activeUser.lastName
                if (activeUser.messageType == "attachment"){
                    lastMessage.text = "Sent an attachment"
                    lastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.attachment,0,0,0)
                }
                if (activeUser.isTyping!!){
                    imageView.visibility = View.VISIBLE
                }
                if (activeUser.messageType == "voice"){
                    lastMessage.text = "Sent a voice message"
                    lastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.voice,0,0,0)
                }
                if (activeUser.messageType == "text"){
                    lastMessage.text = activeUser.lastMessage
                }
                if (activeUser.updatedDate != null) {
                    time.text = getDate(activeUser.updatedDate!!,"h::mm a")
                }


                if (activeUser.unreadMessage == 0){
                    unread.visibility = View.INVISIBLE
                }else{
                    unread.text = activeUser.unreadMessage.toString()
                }



            }
        }

    }

    private fun getDate(mileSeconds:Long, dateFormat: String?):String{
        val formatter = SimpleDateFormat(dateFormat)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = mileSeconds
        return formatter.format(calendar.time)
    }


    class DiffUtilCallback : DiffUtil.ItemCallback<UserModel.UserModelItem>() {
        override fun areItemsTheSame(
            oldItem: UserModel.UserModelItem,
            newItem: UserModel.UserModelItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UserModel.UserModelItem,
            newItem: UserModel.UserModelItem
        ): Boolean {
            return oldItem == newItem
        }
    }


}