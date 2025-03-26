package com.example.fancycomposepetfinder.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fancycomposepetfinder.data.model.Pet
import com.example.fancycomposepetfinder.data.repository.PetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PetViewModel(private val repository: PetRepository): ViewModel() {
    private val _pets = MutableStateFlow<List<Pet>>(emptyList())
    val pets: StateFlow<List<Pet>> = _pets

    fun loadRandomPets() {
        viewModelScope.launch {
            try {
                val item = repository.fetchRandomPets()
//                Log.d("PetViewModel", "Fetched pets = $pets")
                _pets.value = item
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

class PetViewModelFactory(private val repository: PetRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PetViewModel::class.java)) {
            return PetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}