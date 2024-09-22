package com.example.appssquaretask.data.remote


import com.example.appssquaretask.data.model.CitiesData
import com.example.appssquaretask.data.model.LoginResponse
import com.example.appssquaretask.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {

    @FormUrlEncoded
    @POST("sign_up")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @GET("restaurants")
    suspend fun citiesList(
        @Query("skip") skip: Int = 0,
        @Query("search") search: String? = null
    ): Response<CitiesData>

}