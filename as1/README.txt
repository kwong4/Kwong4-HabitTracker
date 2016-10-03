Video Link: https://youtu.be/L4pLRIGe8VM

Note: Currently it may not be able to run on lab machines because I had some issues with trying to get the current API of 18 running on my laptop and tried for a long time to fix. So my app runs with the following gradle properties (up-to-date I believe):

compileSdkVersion 24
buildToolsVersion "24.0.2"

defaultConfig {
	applicationID "com.example.kwong4.kwong4_habittracker"
	minSdkVersion 18
	targetSdkVersion 24
	versionCode 1
	versionName "1.0"
}
buildTypes {
	release {
		minifyEnabled false
		proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
	}
}

dependencies {
	compile fileTree(include: ['*.jar'], dir: 'libs')
	testCompile 'junit:junit:4.12'
	compile 'com.android.support:appcompat-v7:24.2.0'
	compile 'com.google.code.gson:gson:2.7'
}

Sorry if that was extra information. Just wanted to make sure all the information was there.

--------

So, for the app - I have made a Habit-Tracker. Once the app is launched, you will come up to a menu with the option to add, modify, and check the history of completed habits. You are first given a screen with a list of habits (defined by the user). Then you would click on any of the habits listed to mark them complete. TO add habits, you click on the "+" icon and you will be directed to a page where you have to fill out information bout the Name of the Habit, the starting Date of the Habit and the repeating days of the habit. Once you have filled it out and added the habit, you can hit "Back" and return to the screen where you can mark them as complete. Then you can hit the "Edit" button to click on any of the defined habits you made to delete them. You can hit back and finally take a look at the recently completed habits and count per habit in the "History" Tab.

Note: Credit is given to Abram Hindle for inspiration from his code on lonelyTwitter and StudentPicker Series, as well as stackoverflow questions that were referenced.