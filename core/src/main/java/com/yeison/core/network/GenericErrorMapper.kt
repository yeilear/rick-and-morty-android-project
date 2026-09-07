package com.yeison.core.network

import com.yeison.core.network.ResultDomain.Error

object GenericErrorMapper : ErrorMapper() {

    override fun customError(
        code: Int?,
        errorBody: String
    ) = Error(GenericError)

    override fun genericError() = GenericError
}