package com.yeison.rick_and_morty.data.api

import com.yeison.rick_and_morty.data.response.CharacterInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface HomeApi {

    @Headers("Content-Type: application/json; charset=UTF-8")
    @GET("api/character")
    suspend fun getCharacters(): Response<CharacterInfoDto>

}
