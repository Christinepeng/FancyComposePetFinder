package com.example.fancycomposepetfinder.data.network

import com.example.fancycomposepetfinder.data.model.Pet
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/images/search")
    suspend fun getRandomPets(
        @Query("limit") limit: Int = 100
    ): List<Pet>
}

