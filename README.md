# Fetch Rewards Take Home Assignment 
## Overview
This is a Native  Android application developed for the Fetch Interview. The application retrieves data from a provided URL and displays it in an easy-to-read list.

## Features
 Fetches and displays data from [Fetch Hiring API](https://fetch-hiring.s3.amazonaws.com/hiring.json).

 Groups items by `listId` and sorts them by `listId` and `name`. 
 
 Filters out empty or null names. 
 
 Displays data in a Recycler view with a Progress Bar. 

 Uses ViewModel, *Livedata, and Coroutines for efficient data handling.  

## Tech Stack
Language: Kotlin

Architecture: MVVM

Dependency Injection: Hilt

Networking: Retrofit and Gson

Async Processing: Coroutines

## Setup and Installation
### Step 1: Copy the Repository URL
1.Go to GitHub and navigate to your repository.

2.Click the green "Code" button at the top right.

3.Under "Clone", copy the URL (It will look like this):

https://github.com/SeethaIndiran/Fetch-Rewards-Take-Home-Test

###  Step 2: Open Terminal or Command Prompt
Depending on your OS, open one of the following:
* Windows: Open Command Prompt (cmd) or Git Bash.
* Mac/Linux: Open the Terminal.

###  Step 3: Navigate to Your Desired Folder
Decide where you want to save the project. Use the cd command to go to that directory.
For example, if you want to save it in the Documents folder:
cd Documents

###  Step 4: Clone the Repository
Run the following command, replacing <repo-url> with your copied URL:
git clone 
https://github.com/SeethaIndiran/Fetch-Rewards-Take-Home-Test

### Step 5: Navigate Into the Project Folder
Once cloning is complete, move into the project folder using:
cd fetch-hiring

###  Step 6: Open in Android Studio
1. Open Android Studio.
2. Click "Open" and select your cloned repository folder.
3. Wait for Gradle Sync to complete.

### Step 7: Run the Project
1. Click Run  in Android Studio
2. Select an emulator or physical device
3. The app should launch successfully

### Troubleshooting
If you see errors like "git command not found", install Git:
* Windows: Download Git for Windows
* Mac: Git is pre-installed, but you can install it via Homebrew
  brew install git

Now you have successfully cloned and set up your repository! 
     

