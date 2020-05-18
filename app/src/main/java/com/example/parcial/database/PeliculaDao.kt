package com.example.parcial.database

import androidx.room.*
import com.example.parcial.models.Pelicula

@Dao
interface PeliculaDao {
    @Insert
    fun insertPelicula(vararg pelicula: Pelicula)

    @Query("SELECT * FROM peliculas ")
    fun getAllPeliculas(): List<Pelicula>

    @Delete
    fun deletePeliculas(vararg pelicula: Pelicula)

    @Update
    fun updatePeliculas(vararg pelicula: Pelicula)
}