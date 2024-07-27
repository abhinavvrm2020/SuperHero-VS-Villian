package com.example.superherovsvillian.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @StringRes val expandedDescription: Int,
    @DrawableRes val imageRes: Int
)
