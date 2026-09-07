package com.yeison.core.base

import com.yeison.core.network.Result
import com.yeison.core.network.dispatcher.DispatcherProvider
import com.yeison.core.utils.EMPTY_STRING
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

abstract class BaseDataSource {

    @Inject
    lateinit var dispatcherProvider: DispatcherProvider

    protected suspend fun <T> executeNetworkAction(action: suspend () ->T): T =
        withContext(dispatcherProvider.network) { action() }

    protected inline fun <reified T> getResult(call: () -> Response<T>): Result<T> {
        var code = 0
        try {
            val response = call()
            code = response.code()
            if (response.isSuccessful) {
                val body = response.body()
                return Result.success(body)
            }
            return error(
                Exception(response.message()),
                code,
                response.errorBody()?.string().orEmpty(),
                response.body()
            )

        } catch (e: Exception){
            return error(e, code, EMPTY_STRING)
        }
    }

    fun <T> error(e: Exception, code: Int, errorBody: String, data: T? = null): Result<T> {
        return Result.error(e, code, errorBody, data)
    }
}