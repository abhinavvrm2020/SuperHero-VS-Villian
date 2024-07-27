package com.example.superherovsvillian.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Supervillain(
    @DrawableRes val imageResourceId : Int,
    @StringRes val name : Int,
    @StringRes val powers : Int,
    val kills: Int,
    @StringRes val description : Int
)