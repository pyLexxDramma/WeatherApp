// ui/MainActivity.kt
package com.example.weatherapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CityAdapter { city -> onCityClicked(city) }
        recyclerView.adapter = adapter

        viewModel.cities.observe(this) { cities ->
            adapter.submitList(cities)
        }

        findViewById<Button>(R.id.addCityButton).setOnClickListener {
            // Логика для добавления города
        }
    }

    private fun onCityClicked(city: CityEntity) {
        // Логика для отображения подробной информации о погоде
    }
}
