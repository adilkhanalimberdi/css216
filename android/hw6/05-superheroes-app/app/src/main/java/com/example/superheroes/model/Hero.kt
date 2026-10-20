package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @param:StringRes val nameRes: Int,
    @param:StringRes val descriptionRes: Int,
    @param:DrawableRes val imageRes: Int
)
