package com.example.fancycomposepetfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.fancycomposepetfinder.data.network.ApiClient
import com.example.fancycomposepetfinder.data.repository.PetRepository
import com.example.fancycomposepetfinder.ui.PetListScreen
import com.example.fancycomposepetfinder.ui.PetViewModel
import com.example.fancycomposepetfinder.ui.PetViewModelFactory
import com.example.fancycomposepetfinder.ui.theme.FancyComposePetFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = PetRepository(ApiClient.apiService)
        val viewModelFactory = PetViewModelFactory(repository)
        val petViewModel = ViewModelProvider(this, viewModelFactory).get(PetViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            FancyComposePetFinderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { PetListScreen(petViewModel) }
            }
        }
    }
}