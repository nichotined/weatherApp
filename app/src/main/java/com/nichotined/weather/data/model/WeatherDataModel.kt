package com.nichotined.weather.data.model

data class WeatherDataModel(var temperature: String = "") {
    var tempCelcius = temperature.toDouble()
    var tempFahrainheit = temperature.toDouble()
}