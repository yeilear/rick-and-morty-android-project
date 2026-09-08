package com.yeison.rick_and_morty.data.response

import com.google.gson.annotations.SerializedName
import com.yeison.core.extensions.orDefault
import com.yeison.rick_and_morty.domain.model.CharacterInfoEntity
import com.yeison.rick_and_morty.domain.model.InfoEntity
import com.yeison.rick_and_morty.domain.model.ResultsEntity
import kotlin.Int
import kotlin.String

data class CharacterInfoDto(
    @SerializedName("info") val info: InfoDto,
    @SerializedName("results") val results: List<ResultsDto>
)

data class InfoDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("pages") val pages: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)

data class ResultsDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("image") val image: String?
)

fun CharacterInfoDto.mapToDomain() = CharacterInfoEntity(
    info = info.mapToDomain(),
    results = results.map {
        it.mapToDomain()
    }
)

private fun InfoDto.mapToDomain() = InfoEntity(
    count.orDefault(),
    pages.orDefault(),
    next,
    prev
)

private fun ResultsDto.mapToDomain() = ResultsEntity(
    id.orDefault(),
    name.orDefault(),
    status.orDefault(),
    image.orDefault()
)