package com.guilhermegaspar.jokes.network.utils

import com.guilhermegaspar.jokes.network.exception.NetworkException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.net.ConnectException
import java.net.UnknownHostException

fun <T> Flow<T>.parseHttpError(): Flow<T> {
    return catch { throwable ->
        when (throwable) {
            is UnknownHostException,
            is ConnectException -> throw NetworkException()
            else -> throw throwable
        }
    }
}