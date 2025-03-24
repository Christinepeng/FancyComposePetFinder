package com.example.fancycomposepetfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fancycomposepetfinder.data.model.Pet
import com.example.fancycomposepetfinder.ui.PetListScreen
import com.example.fancycomposepetfinder.ui.theme.FancyComposePetFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FancyComposePetFinderTheme {
                val samplePets = listOf(
                    Pet("Fluffy"),
                    Pet("Bella"),
                    Pet("Max"),
                    Pet("Fluffy1"),
                    Pet("Bella1"),
                    Pet("Max1"),
                    Pet("Fluffy2"),
                    Pet("Bella2"),
                    Pet("Max2"),
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PetListScreen(pets = samplePets, Modifier.padding(innerPadding)                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FancyComposePetFinderTheme {
        PetListScreen(
            pets = listOf(
                Pet("Preview Pet 1"),
                Pet("Preview Pet 2")
            ), padding = androidx.compose.ui.Modifier.Companion.padding()
        )
    }
}