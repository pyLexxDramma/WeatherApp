package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.database.CityEntity

class CityAdapter(private val onClick: (CityEntity) -> Unit) :
    ListAdapter<CityEntity, CityAdapter.CityViewHolder>(CityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city, onClick)
    }

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cityName: TextView = itemView.findViewById(R.id.cityName)
        private val cityTemperature: TextView = itemView.findViewById(R.id.cityTemperature)

        fun bind(city: CityEntity, onClick: (CityEntity) -> Unit) {
            cityName.text = city.name
            cityTemperature.text = "${city.temperature} °C"
            itemView.setOnClickListener { onClick(city) }
        }
    }

    class CityDiffCallback : DiffUtil.ItemCallback<CityEntity>() {
        override fun areItemsTheSame(oldItem: CityEntity, newItem: CityEntity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CityEntity, newItem: CityEntity): Boolean {
            return oldItem == newItem
        }
    }
}