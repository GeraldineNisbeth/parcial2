package com.example.parcial.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName =  "peliculas")
data class Pelicula (

    @SerializedName("popularity")
    val popularity : Double,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("title")
    val title: String,
    val release_date:String,
    val original_language :String,
    val original_title : String,
    //val genre_ids : Numeros?,
    val backdrop_path: String?,
    val adult:Boolean,
    @SerializedName("overview")
    val overview: String,
    val poster_path: String?
): Serializable{


}
class Numeros (
    numeros: List<Int>
)
class Converters{
    @TypeConverter
    fun ToNumeros(string : String): Numeros {
        val lista: List<Int> = string.map { it.toInt() }
        val var2:Numeros = Numeros(lista)
        return var2
    }
    @TypeConverter
    fun FromNumeros( numeros: Numeros): String{
        return numeros.toString()
    }
}