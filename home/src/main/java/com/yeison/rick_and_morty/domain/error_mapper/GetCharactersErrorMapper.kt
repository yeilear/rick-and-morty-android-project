package com.yeison.rick_and_morty.domain.error_mapper

import com.yeison.core.network.ErrorMapper
import com.yeison.core.network.GenericError
import com.yeison.core.network.ResultDomain
import com.yeison.rick_and_morty.domain.errors.GetCharactersErrorDomain

object GetCharactersErrorMapper : ErrorMapper() {

    private const val CHARACTERS_NOT_FOUND = 404

    override fun customError(
        code: Int?,
        errorBody: String
    ): ResultDomain.Error {
        val error = when (code) {
            CHARACTERS_NOT_FOUND -> GetCharactersErrorDomain.CharactersNotFoundError
            else -> GenericError
        }
        return ResultDomain.Error(error)
    }

    override fun genericError() = GenericError

}
