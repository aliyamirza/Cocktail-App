package com.smartheard.coctail.Utils


sealed class ApiResponse<out T>{
    data class Success<out R>(val data : R): ApiResponse<R>()
    data class Failure(val msg:String): ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()

}