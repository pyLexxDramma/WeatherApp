package com.example.weatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.AppDatabase
import com.example.weatherapp.data.CityEntity
import com.example.weatherapp.data.CityDao
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val cityDao: CityDao = AppDatabase.getDatabase(application).cityDao()

    val cities: LiveData<List<CityEntity>> = cityDao.getAllCities().asLiveData()

    fun addCity(city: CityEntity) {
        viewModelScope.launch {
            cityDao.insert(city)
        }
    }

    fun deleteCity(city: CityEntity) {
        viewModelScope.launch {
            cityDao.delete(city)
        }
    }
}
