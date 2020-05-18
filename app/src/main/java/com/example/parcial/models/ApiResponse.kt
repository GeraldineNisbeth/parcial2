package com.example.parcial.models

import com.google.gson.annotations.SerializedName

data class ApiResponse
    (
    var page :Int,
    var total_results: Int,
    var total_pages: Int,
    @SerializedName("results")
    var results:List<Pelicula>
)
{
}