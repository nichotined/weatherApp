package com.nichotined.weather.data

import com.nichotined.weather.data.model.WeatherResponse
import com.nichotined.weather.data.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository private constructor(private var weatherDao: WeatherDao) {
    fun getWeather() = weatherDao.getWeather()

    var temperature: String
        get() = weatherDao.getWeather().value!!.temperature
        set(value) {
            weatherDao.getWeather().value?.temperature = value
        }

    fun fetchWeather(q: String, appId: String) {
        return WeatherApi().weatherByCityName(q, appId).enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                print(call)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    weatherDao.addData(response.body() as WeatherResponse)
                } else {
                    println("FAILED")
                }
            }
        })
    }

    companion object {
        @Volatile
        private var instance: WeatherRepository? = null

        fun getInstance(weatherDao: WeatherDao) = instance ?: synchronized(this) {
            instance ?: WeatherRepository(weatherDao).also {
                instance = it
            }
        }
    }
}