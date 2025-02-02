package com.example.weatherapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import com.example.weatherapp.database.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: CityEntity)

    @Query("SELECT * FROM cities")
    suspend fun getAllCities(): List<CityEntity>

    @Delete
    suspend fun delete(city: CityEntity)
}
