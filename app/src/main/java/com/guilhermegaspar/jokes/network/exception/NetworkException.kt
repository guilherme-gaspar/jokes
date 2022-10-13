package com.guilhermegaspar.jokes.network.exception

private const val ERROR_MESSAGE = "Verifique sua conexão com a internet e tente novamente"

class NetworkException(
    override val message: String = ERROR_MESSAGE
) : Exception()