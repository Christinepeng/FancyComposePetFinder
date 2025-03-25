package com.example.fancycomposepetfinder.data.repository

import com.example.fancycomposepetfinder.data.model.Pet
import com.example.fancycomposepetfinder.data.network.ApiService

class PetRepository(private val apiService: ApiService) {
    suspend fun fetchRandomPets(limit: Int = 10): List<Pet> {
        return apiService.getRandomPets(limit)
    }
}