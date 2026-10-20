package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @param:StringRes val stringResId: Int,
    val courseNum: Int,
    @param:DrawableRes val imageResId: Int
)
