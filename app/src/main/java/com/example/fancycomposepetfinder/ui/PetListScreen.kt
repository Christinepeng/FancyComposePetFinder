package com.example.fancycomposepetfinder.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fancycomposepetfinder.data.model.Pet
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.fancycomposepetfinder.R
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


@Composable
fun PetListScreen(petViewModel: PetViewModel) {
    val pets by petViewModel.pets.collectAsState()

    LaunchedEffect(Unit) {
        if (pets.isEmpty()) {
            petViewModel.loadRandomPets()  // 只在「首次進入」時抓資料
            //        println("pets = ${pets}")
        }
    }

    LazyColumn(modifier = Modifier.padding(8.dp, 48.dp, 8.dp, 8.dp)) {
        items(pets) { pet: Pet ->
            PetListItem(pet)
        }
    }
}

@Composable
fun PetListItem(pet: Pet) {
    // 用 remember 建立一個狀態，控制 Dialog 是否顯示
    var showDialog by rememberSaveable { mutableStateOf(false) }

    // 當 showDialog 為 true 時，就顯示 PetDetailDialog
    if (showDialog) {
        PetDetailDialog(pet = pet, onDismiss = { showDialog = false }, pet.url)
    }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { showDialog = true  },
        elevation = CardDefaults. cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = pet.url,
                contentDescription = "Pet image with id ${ pet.id }",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = painterResource(R.drawable.loading_spinner),
                error = painterResource(R.drawable.error_image),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = pet.id,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}