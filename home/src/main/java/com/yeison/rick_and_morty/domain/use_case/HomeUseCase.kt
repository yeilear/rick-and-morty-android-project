package com.yeison.rick_and_morty.domain.use_case

import com.yeison.rick_and_morty.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend fun getCharacters() = repository.getCharacters()
}
