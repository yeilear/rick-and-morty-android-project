package com.yeison.core.network

import com.yeison.core.network.ResultDomain.Error

abstract class ErrorMapper {

    abstract fun customError(code: Int?, errorBody: String) : Error

    abstract fun genericError(): ErrorDomain
}