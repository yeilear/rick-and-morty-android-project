package com.yeison.rick_and_morty.domain.use_case

import com.yeison.core.network.GenericError
import com.yeison.core.network.ResultDomain
import com.yeison.rick_and_morty.TestCoroutineRule
import com.yeison.rick_and_morty.builder.CharactersInfoTestBuilder
import com.yeison.rick_and_morty.domain.repository.HomeRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeUseCaseTest {

    @Rule
    @JvmField
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private val repository = mockk<HomeRepository>()

    private lateinit var useCase: HomeUseCase

    @Before
    fun setUp() {
        useCase = HomeUseCase(repository)
    }

    @Test
    fun `given is success when get characters invoke`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val characters = CharactersInfoTestBuilder().build()
        val response = ResultDomain.Success(characters)

        coEvery { repository.getCharacters() } returns response

        // Act
        val result = useCase.getCharacters()

        // Assert
        assertEquals(response, result)
    }

    @Test
    fun `given is error when get characters invoke`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val response = ResultDomain.Error(GenericError)

        coEvery { repository.getCharacters() } returns response

        // Act
        val result = useCase.getCharacters()

        // Assert
        assertEquals(response, result)
    }
}