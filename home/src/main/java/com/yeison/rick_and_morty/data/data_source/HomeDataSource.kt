package com.yeison.rick_and_morty.data.data_source

import com.yeison.core.network.Result
import com.yeison.rick_and_morty.data.response.CharacterInfoDto

interface HomeDataSource {
    suspend fun getCharacters(): Result<CharacterInfoDto>
}
