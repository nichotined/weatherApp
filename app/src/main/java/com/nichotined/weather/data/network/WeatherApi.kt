package com.nichotined.weather.data.network

import com.nichotined.weather.data.model.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    fun weatherByCityName(
        @Query("q") q: String,
        @Query("appid") appid: String
    ): Call<WeatherResponse>

    companion object {
        operator fun invoke(): WeatherApi {
            return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }
    }
}