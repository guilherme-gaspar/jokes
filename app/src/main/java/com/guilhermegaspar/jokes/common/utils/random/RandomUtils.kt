package com.guilhermegaspar.jokes.common.utils

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

fun getRandomResourceChuckImage(): Int {
    return listOf(
        R.drawable.chuck_1,
        R.drawable.chuck_2,
        R.drawable.chuck_3,
        R.drawable.chuck_4,
        R.drawable.chuck_5
    ).random()
}