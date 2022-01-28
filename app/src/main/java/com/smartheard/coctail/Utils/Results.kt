package com.smartheard.coctail.Utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

fun <T> result(call: suspend () -> Response<T>): Flow<ApiResponse<T?>> = flow {

    emit(ApiResponse.Loading)
    try {
        val c = call()
        c.let {
            if (it.isSuccessful){
                emit(ApiResponse.Success(it.body()))
            }
            else{
                c.errorBody()?.let { error ->
                    error.close()
                    emit(ApiResponse.Failure(error.toString()))
                }
            }
        }
    }
    catch (t : Throwable){
        t.printStackTrace()
        emit(ApiResponse.Failure("${t.message}"))
    }
}