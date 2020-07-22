package com.nichotined.weather.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nichotined.weather.data.WeatherRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    private var weatherRepository: WeatherRepository = Mockito.mock(WeatherRepository::class.java)

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        mainActivityViewModel = MainActivityViewModel(weatherRepository)
    }

    @Test
    fun onToCelsiusClicked() {
        mainActivityViewModel.fetchWeather()
        assertNotNull(mainActivityViewModel.weather)

        mainActivityViewModel.onToCelsiusClicked()
        assertNotNull(mainActivityViewModel.weather.value?.temperature)
    }

    @Test
    fun onToFahrenheit() {
    }
}