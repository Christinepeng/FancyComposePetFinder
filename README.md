# FancyComposePetFinder

FancyComposePetFinder is a Jetpack Compose sample application that demonstrates how to load pet images (cats, dogs, etc.) from a network source using a third-party image loading library (e.g., Coil, Glide, or Picasso). The goal is to showcase modern Android development practices, including Compose-based UI, basic navigation or dialogs, and coroutine-based data fetching.

---

## Features

1. **Pet List Screen**  
   - Displays a scrollable list (or grid) of pet images with names.
   - Each image is loaded asynchronously from an online source.
   - Uses a placeholder image while loading, and an error image if the request fails.
   - Each pet item is shown with rounded corners and a title.

2. **Pet Detail Screen**  
   - When a pet is tapped, shows a larger version of the image and extra details (e.g., pet description) in either a dialog or a separate screen.
   - Demonstrates Compose’s state management for user interactions.

3. **Jetpack Compose**  
   - Utilizes **LazyColumn**, **LazyVerticalGrid**, or similar to display the list of items.
   - Manages UI state using **State** and **ViewModel** (optional).
   - Example usage of **contentScale**, **placeholder**, and **error** parameters for image loading.

4. **Third-Party Image Loading**  
   - Integrates with any one of the following libraries:
     - [Coil](https://github.com/coil-kt/coil)
     - [Glide](https://github.com/bumptech/glide)
     - [Picasso](https://github.com/square/picasso)

---
## Project Structure

Below is a sample structure to highlight key files. This may vary based on your implementation:

``` 
FancyComposePetFinder/ ┣ app/ ┃ ┣ src/main/java/com/example/petfinder/ ┃ ┃ ┣ MainActivity.kt ┃ ┃ ┣ ui/ ┃ ┃ ┃ ┣ PetListScreen.kt # List/Grid of pet items ┃ ┃ ┃ ┣ PetDetailScreen.kt # Full-screen or dialog for item details ┃ ┃ ┃ ┗ components/ # Reusable composables ┃ ┃ ┣ data/ ┃ ┃ ┃ ┣ model/ ┃ ┃ ┃ ┃ ┗ Pet.kt # Pet data class ┃ ┃ ┃ ┣ repository/ ┃ ┃ ┃ ┃ ┗ PetRepository.kt # Fetches data from an API or mock sources ┃ ┃ ┃ ┗ network/ ┃ ┃ ┃ ┃ ┗ ApiService.kt # Networking logic (Retrofit, etc.) ┃ ┗ build.gradle ┣ build.gradle ┣ settings.gradle ┗
``` 

1. **`ui`** folder: Holds all Composable functions, including screens and reusable UI components.
2. **`data`** folder: Contains models, repository classes, and API or network logic.
3. **`MainActivity.kt`**: Entry point for the Compose UI, sets the application content.

---

## Usage Example

Below is a minimal snippet demonstrating how you might load an image with **Coil** inside a `LazyColumn`:

```kotlin
@Composable
fun PetListScreen(pets: List<Pet>) {
    LazyColumn {
        items(pets) { pet ->
            PetListItem(pet)
        }
    }
}

@Composable
fun PetListItem(pet: Pet) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 2.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = pet.imageUrl,
                contentDescription = pet.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.error_image),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = pet.name,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
