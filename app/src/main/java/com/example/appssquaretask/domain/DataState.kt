package com.example.appssquaretask.domain

sealed class DataState<out T> {
    data object Loading : DataState<Nothing>()
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val code: Int, val message: String) : DataState<Nothing>()
}





