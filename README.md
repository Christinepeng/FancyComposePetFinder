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

