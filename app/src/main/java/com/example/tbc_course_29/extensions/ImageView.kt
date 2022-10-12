package com.example.tbc_course_29.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tbc_course_29.R

fun ImageView.setImage(url:String) {

    if (url.isNotEmpty()) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_launcher_background)
    }
}