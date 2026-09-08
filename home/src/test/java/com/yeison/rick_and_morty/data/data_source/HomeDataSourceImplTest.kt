package com.yeison.rick_and_morty.data.data_source

import com.yeison.core.network.Result
import com.yeison.core.utils.EMPTY_STRING
import com.yeison.rick_and_morty.TestCoroutineRule
import com.yeison.rick_and_morty.TestDispatcherProvider
import com.yeison.rick_and_morty.builder.CharactersInfoTestBuilder
import com.yeison.rick_and_morty.data.api.HomeApi
import com.yeison.rick_and_morty.data.response.CharacterInfoDto
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class HomeDataSourceImplTest {

    @Rule
    @JvmField
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private val api = mockk<HomeApi>()

    private lateinit var dataSource: HomeDataSourceImpl

    @Before
    fun setUp() {
        dataSource = HomeDataSourceImpl(api).apply {
            dispatcherProvider = TestDispatcherProvider()
        }
    }

    @Test
    fun `get characters invoke api success`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val dtoList = CharactersInfoTestBuilder().buildDto()
        val response = Response.success(dtoList)
        val expected: Result<CharacterInfoDto> = Result.success(dtoList)

        coEvery { api.getCharacters() } returns response

        // Act
        val result = dataSource.getCharacters()

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun `get characters invoke api error`() = testCoroutineRule.runBlockingTest {
        // Arrange
        val errorCode = 500
        val apiResponse = EMPTY_STRING.toResponseBody("application/json".toMediaType())

        coEvery { api.getCharacters() } returns Response.error(errorCode, apiResponse)

        // Act
        val result = dataSource.getCharacters()

        // Assert
        assertTrue(result.status is Result.Status.ERROR)
    }
}