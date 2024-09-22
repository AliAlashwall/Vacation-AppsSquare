package com.example.appssquaretask.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    @SerialName("data") val userData: UserData,
    @SerialName("status") val status: Boolean,
    @SerialName("message") val message: String
)