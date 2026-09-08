package com.yeison.rick_and_morty.data.repository

import com.yeison.core.network.GenericError
import com.yeison.core.network.Result
import com.yeison.core.network.ResultDomain
import com.yeison.rick_and_morty.TestCoroutineRule
import com.yeison.rick_and_morty.builder.CharactersInfoTestBuilder
import com.yeison.rick_and_morty.data.data_source.HomeDataSource
import com.yeison.rick_and_morty.data.response.CharacterInfoDto
import com.yeison.rick_and_morty.data.response.mapToDomain
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeRepositoryImplTest {

    @Rule
    @JvmField
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private val dataSource = mockk<HomeDataSource>()

    private lateinit var repository: HomeRepositoryImpl

    @Before
    fun setUp() {
        repository = HomeRepositoryImpl(dataSource)
    }

    @Test
    fun `get characters then return success`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val characters = CharactersInfoTestBuilder().buildDto()
        val response =Result.success(characters)
        val expected = ResultDomain.Success(characters.mapToDomain())

        coEvery { dataSource.getCharacters() } returns response

        // Act
        val result = repository.getCharacters()

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `get characters then return generic error`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val errorCode = 500
        val response = Result.error<CharacterInfoDto>(Exception(), errorCode)

        coEvery { dataSource.getCharacters() } returns response

        // Act
        val result = repository.getCharacters()

        // Assert
        assertEquals(ResultDomain.Error(GenericError), result)
    }
}