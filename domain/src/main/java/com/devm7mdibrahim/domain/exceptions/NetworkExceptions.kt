package com.devm7mdibrahim.domain.exceptions

sealed class NetworkExceptions : Exception() {
    object UnknownException : NetworkExceptions()
    object ServerException : NetworkExceptions()
    object NotFoundException : NetworkExceptions()
    object TimeoutException : NetworkExceptions()
    object ConnectionException : NetworkExceptions()
    data class CustomException(val msg: String) : NetworkExceptions()
}