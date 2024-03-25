package com.m0521062.meowapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable
