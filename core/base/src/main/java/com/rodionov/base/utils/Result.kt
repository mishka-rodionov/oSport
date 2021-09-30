package com.rodionov.base.utils

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String, val error: Throwable) : Result<Nothing>()
}
