package com.yeison.rick_and_morty.domain.repository

import com.yeison.core.network.ResultDomain
import com.yeison.rick_and_morty.domain.model.CharacterInfoEntity

interface HomeRepository {
    suspend fun getCharacters(): ResultDomain<CharacterInfoEntity>
}
