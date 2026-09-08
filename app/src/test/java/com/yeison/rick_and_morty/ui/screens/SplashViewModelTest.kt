package com.yeison.rick_and_morty.ui.screens

import com.yeison.core.navigation.Routes
import com.yeison.rick_and_morty.TestCoroutineRule
import com.yeison.rick_and_morty.TestDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    @Rule
    @JvmField
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: SplashViewModel

    @Before
    fun setUp() {
        viewModel = SplashViewModel().apply {
            appDispatcher = TestDispatcherProvider()
        }
    }

    @Test
    fun `onTimeout should update destination to Home route`() = testCoroutineRule.runBlockingTest {
        // Act
        viewModel.onTimeout()

        // Assert
        val destination = viewModel.destination.value
        Assert.assertEquals(Routes.Home.route, destination)
    }
}
