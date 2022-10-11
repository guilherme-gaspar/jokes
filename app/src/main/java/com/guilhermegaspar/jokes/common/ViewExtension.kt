package com.guilhermegaspar.jokes.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.guilhermegaspar.jokes.R

fun getRandomResourceColor(): Int {
    return listOf(
        R.color.black,
        R.color.red,
        R.color.blue,
        R.color.white,
        R.color.purple,
        R.color.orange,
        R.color.green
    ).random()
}

fun ImageView.setImageFromUrl(url: String?, context: Context) {
    Glide
        .with(context)
        .load("https://www.pecsma.hu/wp-content/uploads/2018/11/Chuck5.png")
        .centerCrop()
        .into(this)
}