package com.example.fancycomposepetfinder.data.network

import com.example.fancycomposepetfinder.data.model.Pet
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/images/search")
    suspend fun getRandomPets(  // get 10 random pets images
//        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int = 10
    ): List<Pet>
}

