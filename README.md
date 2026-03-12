Project Description
The Daily Mood Journal App is an Android mobile application developed as part of the Mobile Application Development module.
The purpose of this application is to help users track and reflect on their daily emotions by selecting their mood and writing short notes. The system stores mood records and allows users to view their emotional history over time.
The application includes user authentication, mood tracking, and history viewing features using an SQLite database.
This project demonstrates the use of Android development, database integration, login systems, and CRUD operations.
🎯 Project Objectives
•	Allow users to register and login securely
•	Record daily moods with optional notes
•	Store user data using SQLite database
•	Allow users to view their mood history
•	Ensure users can only access their own data

✨ Features
🔐 Authentication
•	User Registration
•	User Login
•	User Logout
•	Session management
😊 Mood Tracking
•	Select mood (Happy, Neutral, Sad, etc.)
•	Add optional notes
•	Save mood entry
📅 Mood History
•	View previous mood records
•	Display moods by date
✏ CRUD Operations
•	Create mood entry
•	Read mood history
•	Update mood entry
•	Delete mood entry

🗄 Database Structure
Users Table
Field	Type	Description
id	INTEGER	Primary key
email	TEXT	User email
password	TEXT	Encrypted password
Mood Table
Field	Type	Description
id	INTEGER	Primary key
user_id	INTEGER	Foreign key
mood	TEXT	Selected mood
note	TEXT	Optional note
date	TEXT	Entry date


🛠 Technologies Used
•	Android Studio
•	Java
•	SQLite Database
•	XML (UI Design)
•	GitHub (Version Control)

📱 Application Screens
•	Splash Screen
•	Login Screen
•	Registration Screen
•	Mood Selection Screen
•	Add Mood Entry Screen
•	Mood History Screen

👨‍💻 Team Members
Name	Registration Number
Mr.S.Birunthatharan	ICT/2022/028
Ms.C.A.Kumarawadu	ICT/2022/033
Mr.S.H.D.Mihidumpita	ICT/2022/027







Project
│
├── Java Files
│   ├── LoginActivity.java
│   ├── RegisterActivity.java
│   ├── HomeActivity.java
│   ├── MoodSelection.java
│   ├── MoodHistory.java
│   ├── Splash.java
│   └── MainActivity.java
│
├── Database
│   └── DBHelper.java
│
├── Session
│   └── SessionManager.java
│
└── XML Layout Files
    ├── activity_login.xml
    ├── activity_register.xml
    ├── activity_home.xml
    ├── activity_mood_selection.xml
    ├── activity_mood_history.xml
    ├── activity_splash.xml
    └── activity_main.xml
🚀 How to Run the Project
1.	Clone the repository
https://github.com/birunthatharan/MAD_Mood_Tracking.git
2.	Open the project in Android Studio
3.	Sync Gradle
4.	Run the application using Android Emulator or Physical Device
