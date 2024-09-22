package com.example.appssquaretask.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    @SerialName("email") val email: String,
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String
)