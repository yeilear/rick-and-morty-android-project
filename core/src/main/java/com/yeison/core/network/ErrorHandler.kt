package com.yeison.core.network

import com.yeison.core.network.Result.Status.SUCCESS
import com.yeison.core.network.Result.Status.ERROR
import com.yeison.core.network.ResultDomain.Error

suspend fun <T,O> errorHandler(
    mapper: ErrorMapper,
    response: Result<T>,
    mapAction: suspend (T) -> ResultDomain<O>
): ResultDomain<O> = when (val statusResponse = response.status) {
    is SUCCESS -> response.data?.let {mapAction(it) } ?: Error(mapper.genericError())
    is ERROR-> mapper.customError(statusResponse.code, statusResponse.errorBody)
}