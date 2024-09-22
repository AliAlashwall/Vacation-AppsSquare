package com.example.appssquaretask.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("data") val userData: UserData,
    @SerialName("message") val message: String,
    @SerialName("status") val status: Boolean,
    @SerialName("token") val token: String
)