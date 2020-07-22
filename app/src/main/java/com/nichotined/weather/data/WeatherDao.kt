package com.nichotined.weather.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nichotined.weather.data.model.WeatherDataModel
import com.nichotined.weather.data.model.WeatherResponse

class WeatherDao {
    private var weather: WeatherDataModel = WeatherDataModel("0")
    private val result = MutableLiveData<WeatherDataModel>()

    init {
        result.value = weather
    }

    fun addData(weather: WeatherResponse) {
        this.weather = WeatherDataModel(weather.main.temp.toString())
        result.value = this.weather
    }

    fun getWeather() = result as LiveData<WeatherDataModel>
}