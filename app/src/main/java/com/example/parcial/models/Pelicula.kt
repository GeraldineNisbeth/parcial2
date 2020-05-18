package com.example.parcial.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName =  "peliculas")
data class Pelicula (
    @PrimaryKey
    @SerializedName("popularity")
    val popularity : Double,
    val id: Int,
    val video: Boolean,
    val vote_count: Int,
    val vote_average: Double,
    @SerializedName("title")
    val title: String,
    val release_date:String,
    val original_language :String,
    val backdrop_path: String,
    val adult:Boolean,
    @SerializedName("overview")
    val overview: String,
    val poster_path: String
): Serializable{


}