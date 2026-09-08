package com.yeison.rick_and_morty.app.ui.screen

import com.yeison.core.network.ResultDomain
import com.yeison.home.R
import com.yeison.rick_and_morty.TestCoroutineRule
import com.yeison.rick_and_morty.TestDispatcherProvider
import com.yeison.rick_and_morty.app.state.HomeUiState
import com.yeison.rick_and_morty.builder.CharactersInfoTestBuilder
import com.yeison.rick_and_morty.domain.errors.GetCharactersErrorDomain
import com.yeison.rick_and_morty.domain.use_case.HomeUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @Rule
    @JvmField
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private val useCase = mockk<HomeUseCase>()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(useCase).apply {
            appDispatcher = TestDispatcherProvider()
        }
    }

    @Test
    fun `load characters info and return success`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val charactersInfo = CharactersInfoTestBuilder().build()
        val expectedCharacters = charactersInfo.results
        val response = ResultDomain.Success(charactersInfo)

        coEvery { useCase.getCharacters() } returns response

        // Act
        viewModel.getCharacters()

        // Assert
        val state = viewModel.viewState.value
        Assert.assertTrue(state is HomeUiState.Success)
        Assert.assertEquals(expectedCharacters, (state as HomeUiState.Success).characters)
    }

    @Test
    fun `load characters info and return error`() = testCoroutineRule.runBlockingTest {
        // Arrange
        coEvery { useCase.getCharacters() } returns ResultDomain.Error(mockk())

        // Act
        viewModel.getCharacters()

        // Assert
        val state = viewModel.viewState.value
        Assert.assertTrue(state is HomeUiState.Error)
        Assert.assertEquals(R.string.home_error_message, (state as HomeUiState.Error).message)
    }

    @Test
    fun `load characters info and return characters not found error`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val response = ResultDomain.Error(GetCharactersErrorDomain.CharactersNotFoundError)

        coEvery { useCase.getCharacters() } returns response

        // Act
        viewModel.getCharacters()

        // Assert
        val state = viewModel.viewState.value
        Assert.assertTrue(state is HomeUiState.Error)
        Assert.assertEquals(R.string.home_not_found_error_message, (state as HomeUiState.Error).message)
    }

}
