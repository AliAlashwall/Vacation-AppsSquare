package com.example.appssquaretask.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CitiesData(
    @SerialName("count")
    val count: Int,
    @SerialName("data")
    val data: List<Restaurant>,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Boolean
)

@Serializable
data class Restaurant(
    @SerialName("address")
    val address: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("products")
    val products: List<Product>,
    @SerialName("restaurant_lat")
    val restaurantLat: String,
    @SerialName("restaurant_long")
    val restaurantLong: String
)

@Serializable
data class Product(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("quantity")
    val quantity: Int,
    @SerialName("restaurant_id")
    val restaurantId: Int
)
