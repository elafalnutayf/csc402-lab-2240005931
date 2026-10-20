# CSC 402 Lab Tasks

- **Name:** Elaf Hassan Al-Nutayf
- **Student ID:** 2240005931
- **Section:** 01

Android application development exercises using Kotlin and Jetpack Compose, alongside the StudyPlanner semester application.

## Labs

Each lab folder contains its source code, report, and screenshots.

### Lab 02
Jetpack Compose fundamentals, including layouts, state, lists, and state hoisting. Exercises cover displaying content, handling user input, and updating the interface through state changes.

### Lab 03
Jetpack Compose layouts, modifiers, Material Design 3, and theming. Exercises include organizing screens with `Scaffold`, displaying lists with `LazyColumn`, and creating composable previews.

### Lab 04
Activities, launcher configuration, immutable UI state, stateless composables, previews, and state hoisting. The check-in exercise compares state updates using `copy()` with an intentional frozen-state experiment.

### Lab 05
Implicit intents for opening a website, launching the dialer, and sharing text. Type-safe navigation connects Home, Course List, and Course Detail, with argument passing and error-handling experiments.

## Semester App – StudyPlanner

### Part 1: Home Screen and State
A home screen built with `PlannerUiState`, a stateless `PlannerHomeScreen`, and two previews. `PlannerHomeRoute` manages completed-task updates using `copy()`, with Material Design 3 and a single launcher Activity.

### Part 2: Task Navigation and Sharing
Task navigation using serializable routes and title arguments. Includes a stateless detail screen, Back navigation, text sharing through the Android Sharesheet, and two detail previews.
