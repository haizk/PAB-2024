package com.coba.cobaretrofit.data.response

import com.google.gson.annotations.SerializedName

// Data class untuk menampung response dari API terkait informasi user
data class UserResponse (
    @field:SerializedName("website")
    val website: String,

    @field:SerializedName("phone")
    val phone: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("username")
    val username: String
)