package com.guilhermegaspar.jokes.common.extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.guilhermegaspar.jokes.R
import com.guilhermegaspar.jokes.common.constants.DEFAULT_CHUCK_NORRIS_URL_IMAGE

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
    val imageUrl = if (url.isNullOrBlank()) DEFAULT_CHUCK_NORRIS_URL_IMAGE else url
    Glide
        .with(context)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}