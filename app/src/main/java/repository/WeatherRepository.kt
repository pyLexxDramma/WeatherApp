package com.example.weatherapp.repository

import com.example.weatherapp.data.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): WeatherResponse
}
class WeatherRepository() {
    // Функция для получения погоды из API
    suspend fun fetchWeather(cityName: String, apiKey: String): WeatherResponse {
        val weatherApi = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
        return weatherApi.getWeather(cityName, apiKey)
    }
}