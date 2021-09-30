package com.rodionov.base.platform

import com.google.gson.Gson
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException
import com.rodionov.base.platform.Failure.*

class ErrorHandler(
    private val networkHandler: NetworkHandler,
    private val gson: Gson
) {

    fun proceedException(exception: Throwable): Failure {
        when {
            withoutNetworkConnection() -> {
                return NetworkConnection
            }

            exception is HttpException -> {
                try {
//                    val error = gson.fromJson(exception.response()?.errorBody()?.string(), ErrorResponse::class.java)
                    val error = ""
                    return when (error) {
                        "AuthFailed" -> AuthError
                        "RequestUnacceptableFormat" -> UnacceptableFormatError
                        "RequestUploadingError" -> UploadingError
                        "AuthInvalidBody" -> CommonError
                        "AuthRequired" -> CommonError
                        "AuthInvalidToken" -> CommonError
                        "NewsNotFound" -> CommonError
                        "NewsRouteNotFound" -> CommonError
                        "RequestInvalidType" -> CommonError
                        "RequestInvalidBody" -> CommonError
                        "RequestInvalidCriticality" -> CommonError
                        "RequestNotFound" -> CommonError
                        "RequestNotFoundForUser" -> CommonError
                        "RequestRouteNotFound" -> CommonError
                        "NotificationNotFound" -> CommonError
                        "NotificationNotFoundForUser" -> CommonError
                        "UnknownError" -> CommonError
                        else -> CommonError
                    }
                } catch (e: Exception) {
                    ServerError
                }
            }

            exception is SocketTimeoutException -> {
                return ServerError
            }

            exception is CancellationException -> {
                return CommonError
            }

            exception is KotlinNullPointerException -> {
                return CommonError
            }

            else -> CommonError
        }

        return CommonError
    }

    fun withoutNetworkConnection() = !networkHandler.isConnected
}