package com.example.parcial.network

import com.example.parcial.models.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface PeliculaService {
    @GET("movie")
    fun getPeliculas(@Query("api_key") api_key: String, @Query("query") query : String):Call<ApiResponse>
}