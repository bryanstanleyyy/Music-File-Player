# Music File Player 🎶

This project is a Java application that reads musical notes from a text file and plays them using the Java Sound API. It supports playing music in the form of textual note representations (e.g., "C4", "D#4", "E4") and can play melodies in a MIDI-like format.

## Features
- Reads musical notes from a text file.
- Supports playing music from a wide range of note representations (Western notation).
- Uses Java Sound API to play the notes in real-time.

## Prerequisites
To run the project, you need:
- Java Development Kit (JDK) 8 or later.
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse).

## How to Run

### 1. Clone the Repository
Clone the project to your local machine using Git:
```bash
git clone https://github.com/bryanstanleyyy/Music-File-Player.git
cd Music-File-Player
```

### 2. Compile the Code
After cloning, you can compile the project using the following command:
```bash
javac src/MusicFilePlayer.java
```

### 3. Run the Program
To run the program, use this command:
```bash
java -cp src MusicFilePlayer notes/ode_to_joy.txt
```

### 4. Input File
The program reads musical notes from a text file (e.g., `ode_to_joy.txt`). Notes should be in the format of Western musical notation (e.g., `C4`, `D#4`, `E4`, etc.) with spaces separating each note. You can create your own text file with notes or use the provided sample files.

Example format for the text file:
```plaintext
E4 E4 F4 G4 G4 F4 E4 D4
C4 C4 D4 E4 E4 D4 D4
E4 E4 F4 G4 G4 F4 E4 D4
C4 C4 D4 E4 D4 C4 C4
```

### 5. Customizing Notes
You can modify the note file (`ode_to_joy.txt`) or create a new one based on your favorite pieces of music. The program will read the file and play the notes as they are written.

## License
This project is open-source and licensed under the MIT License. See the LICENSE file for more details.
