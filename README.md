# Movie Explorer

## Overview

Movie Explorer is an Android application built with Kotlin and Jetpack Compose that allows you to discover and learn about movies. It leverages the power of the [OMDb API](http://www.omdbapi.com/) to fetch comprehensive movie details and utilizes local storage to keep track of your favorite finds.

## Key Features

* **Explore a World of Movies:** Start your journey on the home screen with quick access to various movie-related functionalities.
* **Local Movie Database:** Easily add details of specific movies to your personal database for offline access.
* **Effortless Movie Search:** Search for movies by title and instantly retrieve detailed information from the web.
* **Save Your Discoveries:** Found a movie you love? Save its details directly to your local database for future reference.
* **Actor-Based Search:** Discover movies featuring your favorite actors by searching your local database for their names. The search is smart and will find matches even if you only type part of the name.
* **Seamless Experience:** Enjoy a smooth and consistent user experience, even when rotating your device. The app remembers where you were and what you were doing.
* **Web Title Search:** Explore the vast OMDb API directly by typing a movie title (or part of it) and instantly see a list of matching movies from the web.

## Technologies Used

* **Kotlin:** The primary language for building the application.
* **Jetpack Compose:** A modern Android UI toolkit for creating beautiful and responsive interfaces.
* **Android API Libraries:** Standard Android libraries.
* **Room Persistence Library:** For efficient and reliable local data storage.
* **OMDb API:** A powerful web service for retrieving movie information.

## Video Demo

See the application in action! A video showcasing all the features is available on YouTube:

[**youtube video comming soon**]

## Setup

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/saifullahhaaris/movie-app-kotlin/
    ```
2.  **Open the project in Android Studio.**
3.  **Obtain an OMDb API Key:**
    * Visit [http://www.omdbapi.com/apikey.aspx](http://www.omdbapi.com/apikey.aspx) to get your free API key.
    * Create a `local.properties` file in the root of your project if it doesn't exist.
    * Add your API key to `local.properties` like this:
        ```properties
        omdbApiKey="YOUR_ACTUAL_OMDB_API_KEY"
        ```
4.  **Run the application** on an Android emulator or a physical device.

