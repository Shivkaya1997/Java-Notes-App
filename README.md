# Java Notes App

A simple command-line application to manage text-based notes using Java File I/O.

🚀 Features
- Write Mode: Create a fresh note (overwrites existing content).
- Append Mode: Add new thoughts to your existing list without deleting old ones.
- Read Mode: Display all saved notes directly in the terminal.
- Error Handling: Gracefully handles missing files and system errors.

🛠️ Tools Used
- Language: Java 17+ (Uses modern `switch` expressions).
- File I/O: `BufferedWriter`, `BufferedReader`, `FileWriter`, and `FileReader`.
- Environment: VS Code & Terminal.

📂 File Handling
- All data is saved to a file named `notes.txt` in the project root directory.

💻 How to Use
1. Compile:
   ```bash
   javac NotesApp.java
