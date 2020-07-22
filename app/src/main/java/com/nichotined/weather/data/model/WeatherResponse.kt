package com.nichotined.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("coord")
    @Expose
    var coord: Any? = null

    @SerializedName("weather")
    @Expose
    var weather: Any? = null

    @SerializedName("base")
    @Expose
    var base: Any? = null

    @SerializedName("main")
    @Expose
    var main: Main = Main()

    @SerializedName("visibility")
    @Expose
    var visibility: Any? = null

    @SerializedName("wind")
    @Expose
    var wind: Any? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Any? = null

    @SerializedName("dt")
    @Expose
    var dt: Any? = null

    @SerializedName("sys")
    @Expose
    var sys: Any? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Any? = null

    @SerializedName("id")
    @Expose
    var id: Any? = null

    @SerializedName("name")
    @Expose
    var name: Any? = null

    @SerializedName("cod")
    @Expose
    var cod: Any? = null

    class Main {
        var temp: Double = 1.0
    }
}
