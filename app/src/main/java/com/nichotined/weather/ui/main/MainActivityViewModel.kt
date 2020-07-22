package com.nichotined.weather.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nichotined.weather.data.WeatherRepository
import com.nichotined.weather.data.model.WeatherDataModel

class MainActivityViewModel(private val repository: WeatherRepository) : ViewModel() {
    val weather: LiveData<WeatherDataModel>
        get() = repository.getWeather()

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        repository.fetchWeather("Jakarta", "df82898f85cd74732496012d4e0d1a1a")
    }

    fun onToCelsiusClicked() {
        repository.temperature = repository.temperature
            .toDouble()
            .minus(273.15)
            .toString()
    }

    fun onToFahrenheit() {
        repository.temperature = repository.temperature
            .toDouble()
            .minus(273.15)
            .times(9)
            .div(5)
            .plus(32)
            .toString()
    }
}