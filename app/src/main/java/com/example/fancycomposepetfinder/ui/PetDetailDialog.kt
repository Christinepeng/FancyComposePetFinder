package com.example.fancycomposepetfinder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.fancycomposepetfinder.data.model.Pet
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fancycomposepetfinder.R

@Composable
fun PetDetailDialog(pet: Pet,
                    onDismiss: () -> Unit,
                    imageUrl: String) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Pet Details") },
        text = {
            Column  {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "",
                    modifier = Modifier.size(80.dp).clip(RoundedCornerShape(8.dp)),
                    placeholder = painterResource(R.drawable.loading_spinner),
                    error = painterResource(R.drawable.error_image),
                    contentScale = ContentScale.Crop)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Id: ${pet.id}\n" +
                        "Height: ${pet.height}\n" +
                        "Width: ${pet.width}")
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Close")
            }
        }
    )
}