package com.yeison.rick_and_morty.builder

import com.yeison.core.extensions.ZERO
import com.yeison.core.utils.EMPTY_STRING
import com.yeison.rick_and_morty.app.ui.model.CharacterStatus
import com.yeison.rick_and_morty.data.response.CharacterInfoDto
import com.yeison.rick_and_morty.data.response.InfoDto
import com.yeison.rick_and_morty.data.response.ResultsDto
import com.yeison.rick_and_morty.domain.model.CharacterInfoEntity
import com.yeison.rick_and_morty.domain.model.InfoEntity
import com.yeison.rick_and_morty.domain.model.ResultsEntity
import kotlin.Int

data class CharactersInfoTestBuilder(
    val info: InfoData = InfoData(),
    val results: ResultsData = ResultsData()
) {
    fun buildDto() = CharacterInfoDto(
        InfoDto(
            info.count,
            info.pages,
            info.next,
            info.prev
        ),
        listOf(
            ResultsDto(
                results.id,
                results.name,
                results.status,
                results.image
            )
        )
    )

    fun build() = CharacterInfoEntity(
        InfoEntity(
            info.count,
            info.pages,
            info.next,
            info.prev
        ),
        listOf(
            ResultsEntity(
                results.id,
                results.name,
                results.statusModel,
                results.image
            )
        )
    )
}

data class InfoData(
    val count: Int = Int.ZERO,
    val pages: Int = Int.ZERO,
    val next: String? = null,
    val prev: String? = null
)

data class ResultsData(
    val id: Int = Int.ZERO,
    val name: String = EMPTY_STRING,
    val status: String = CharacterStatus.ALIVE.status,
    val statusModel: CharacterStatus = CharacterStatus.ALIVE,
    val image: String = EMPTY_STRING
)