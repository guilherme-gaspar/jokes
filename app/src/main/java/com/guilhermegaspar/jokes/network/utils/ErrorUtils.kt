package com.guilhermegaspar.jokes.network.utils

import com.guilhermegaspar.jokes.network.exception.NetworkException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.net.ConnectException

fun <T> Flow<T>.parseHttpError(): Flow<T> {
    return catch { throwable ->
        if (throwable is ConnectException) {
            throw NetworkException()
        }
    }
}