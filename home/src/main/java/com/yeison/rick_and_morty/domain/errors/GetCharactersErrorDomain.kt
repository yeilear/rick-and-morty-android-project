package com.yeison.rick_and_morty.domain.errors

import com.yeison.core.network.ErrorDomain

sealed class GetCharactersErrorDomain : ErrorDomain() {
    data object CharactersNotFoundError : GetCharactersErrorDomain()
}
