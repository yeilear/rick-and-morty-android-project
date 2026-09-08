package com.yeison.rick_and_morty.data.repository

import com.yeison.core.network.GenericErrorMapper
import com.yeison.core.network.ResultDomain
import com.yeison.core.network.errorHandler
import com.yeison.rick_and_morty.data.data_source.HomeDataSource
import com.yeison.rick_and_morty.data.response.mapToDomain
import com.yeison.rick_and_morty.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {

    override suspend fun getCharacters() = errorHandler(
        GenericErrorMapper,
        dataSource.getCharacters()
    ) {
        ResultDomain.Success(it.mapToDomain())
    }

}
