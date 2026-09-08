package com.yeison.rick_and_morty.data.data_source

import com.yeison.core.base.BaseDataSource
import com.yeison.core.network.Result
import com.yeison.rick_and_morty.data.api.HomeApi
import com.yeison.rick_and_morty.data.response.CharacterInfoDto
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val api: HomeApi
) : HomeDataSource, BaseDataSource() {

    override suspend fun getCharacters(): Result<CharacterInfoDto> = getResult {
        executeNetworkAction {
            api.getCharacters()
        }
    }

}
