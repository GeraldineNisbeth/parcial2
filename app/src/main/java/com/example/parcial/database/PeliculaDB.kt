package com.example.parcial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.parcial.models.Converters
import com.example.parcial.models.Pelicula

@Database(entities = [Pelicula::class], version = 1)
@TypeConverters(Converters::class)
abstract class PeliculaDB:RoomDatabase() {
    abstract fun getPeliculaDAO() : PeliculaDao

    companion object {

        private var INSTANCE : PeliculaDB?= null
        fun getInstance(context: Context) : PeliculaDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, PeliculaDB::class.java, "pelicula3.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as PeliculaDB
        }
    }
}