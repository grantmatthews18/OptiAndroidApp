# Optimizely Android Test App

I built this app with the simple intent of providing a test enviroment for the Optimizely Android SDK.

## Installation

To install and run the app on the computer you need to do the following:

1. Download and install [Android Studio](https://developer.android.com/studio). This will vary depending on what OS you have installed
2. Download the .zip file containing all the code in this repo from the latest release. Extract the .zip file to a folder
3. Open Android Studio. Select Projects on the left and hit the *Open* button. Navigate to the folder where you extracted the .zip file and select Open Folder
   ![Step 3 Image](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Install/step3.png?raw=true)
4. After Android Studio has loaded, use the right sidebar to select Device Manager. If there is already an emulator preinstalled, you'll see it listed and you may skip this step. Otherwise, select the plus button to create a new emulator:
   ![Step 4 Image](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Install/step4.png?raw=true)
   1. Select Create Virtual Device
   2. Select a Phone Model. Any will do, I recommend a newer model such as the Pixel 8
   3. Select an OS version. You may need to wait while Android Studio downloads the OS image
5. Hit the *Play* button next to the device you want to use in the Device Manager
   ![Step 5 Image](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Install/step5.png?raw=true)
6. After the Virtual Device starts up, you should see an Android Homescreen. To run the app, hit the Run button in the top toolbar of Android Studio. Any time you make changes to the app, you will need to hit this button to rebuild the application. For mor information see **Use** below.
   ![Step 6 Image](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Install/step6.png?raw=true)

## Use

To use the application for testing please use the following as reference.

### Change the SDK Version

SDK Versions for the Optimizely Android SDK are hosted on [Maven Central](https://mvnrepository.com/artifact/com.optimizely.ab/android-sdk) per [Optimizely Documentation](https://docs.developers.optimizely.com/feature-experimentation/docs/install-sdk-android). This app is already set up to pull and include the Optimizely SDK from MavenCentral. The version of the SDK that is pulled can be specifed in the build.gradle. To change the SDK version, modify the App's build.gradle as shown below. Specify the SDK version you'd like use. For a full list of available SDK Versions, see [Maven Central](https://mvnrepository.com/artifact/com.optimizely.ab/android-sdk).
![Change SDK Version](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Use/change_sdk.png?raw=true)

### Change Optimizely Variables

The main app code lives in the MainActivity.kt. To edit the file, first ensure you're viewing the project code in the Android View. Navigate to app/kotlin+java/com.example.optiTest/MainActivity.kt. Towards the top of the file you'll see variables that need to be set as follows:

| Variable   | Value                                                             | Notes                                                                                                           |
| ---------- | ----------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| sdkKey     | The Enviroment Key of the Optimizely Enviroment your testing with |                                                                                                                 |
| flagKey    | The Flag Key of the Optimizely Feature Flag being decided on     |                                                                                                                 |
| attributes | The attributes you want to add to the user context                | The attributes variable is a hashmap, add key:value pairs to the hashmap using the format in the commented line |
| userID     | User ID for the user being decided on                             |                                                                                                                 |

![Setup App](https://github.com/grantmatthews18/OptiAndroidApp/blob/main/Docs/Use/setup.png?raw=true)

#### Todo in Future Releases

* Add Loop to print out Variation Variables
* Add button for conversion event
