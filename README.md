# FancyComposePetFinder

An Android app built with Jetpack Compose that fetches random pet data from a network API using Retrofit. It displays the pets in a scrollable list, and tapping on any item shows a dialog with detailed information.

---

## Features

- **Jetpack Compose** for building the UI (lists, cards, dialogs, etc.).
- **MVVM Architecture**: Organized into ViewModel, Repository, and Data layers for clarity and maintainability.
- **Retrofit + OkHttp** for network requests and data parsing.
- **Coroutines & StateFlow**: Asynchronous data loading in the ViewModel, and reactive UI updates via StateFlow.
- **Coil**: Efficient loading and displaying of images from the internet.
- **Rotation Persistence**: Uses `rememberSaveable` (or ViewModel state) so data isn’t lost when rotating the screen.
- **Detail Dialog**: Tapping on any pet card opens a dialog with additional details such as pet ID and dimensions.

---

## Screenshots

| List Screen | Detail Dialog |
|-------------|---------------|
| ![Image](https://github.com/user-attachments/assets/303bdcab-4bcf-4275-b116-dafcc9613e2d) | ![Image](https://github.com/user-attachments/assets/9f790119-4c2f-44c2-8145-4d255ac27737) |

---

## Requirements

- **Android Studio Giraffe** (or higher)
- **Gradle 8+**
- **Kotlin 1.8+**
- **Android 5.0 (API 21)** or higher for the target device/emulator

---

## Usage

- **Launch** the app to see a list of pets.
- **Tap** on any pet card to open a dialog showing more details and a larger image.
- **Close** the dialog to return to the list.
- **Rotate** the screen to confirm that the data and dialog state are preserved.

---

## Key Libraries & Technologies

- **Jetpack Compose**: Declarative UI toolkit for Android.
- **Retrofit**: Simplified network requests and JSON deserialization.
- **OkHttp**: HTTP client for underlying network transport.
- **Coil**: Image loading library optimized for Compose.
- **Coroutines & StateFlow**: Asynchronous programming and reactive data flow.

