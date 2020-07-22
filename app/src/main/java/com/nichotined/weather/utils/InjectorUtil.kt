package com.nichotined.weather.utils

import com.nichotined.weather.data.WeatherDao
import com.nichotined.weather.data.WeatherRepository
import com.nichotined.weather.ui.main.MainActivityViewModelFactory

object InjectorUtil {
    fun provideMainViewModelFactory(): MainActivityViewModelFactory {
        val weatherDao = WeatherDao()
        val weatherRepository = WeatherRepository.getInstance(weatherDao)
        return MainActivityViewModelFactory(weatherRepository)
    }
}