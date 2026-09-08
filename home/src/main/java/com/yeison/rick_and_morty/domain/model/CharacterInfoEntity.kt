package com.yeison.rick_and_morty.domain.model

import com.yeison.rick_and_morty.app.ui.model.CharacterStatus

data class CharacterInfoEntity(
    val info: InfoEntity,
    val results: List<ResultsEntity>
)

data class InfoEntity(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class ResultsEntity(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val image: String
)