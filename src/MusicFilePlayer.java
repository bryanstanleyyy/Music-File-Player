import javax.sound.midi.*;
import java.io.*;
import java.util.*;

public class MusicFilePlayer {
    public static void main(String[] args) {
        // Check if the file path is provided as a command-line argument
        if (args.length < 1) {
            System.out.println("Usage: java MusicFilePlayer <path_to_txt_file>");
            return;
        }

        String filePath = args[0];

        // List to hold the notes read from the file
        List<String> notes = new ArrayList<>();

        // Read the notes from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Play the notes
        try {
            playNotes(notes);
        } catch (Exception e) {
            System.out.println("Error playing notes: " + e.getMessage());
        }
    }

    public static void playNotes(List<String> notes) throws Exception {
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        MidiChannel[] channels = synthesizer.getChannels();
        MidiChannel channel = channels[0];

        for (String note : notes) {
            int midiNote = noteToMidi(note);
            if (midiNote != -1) {
                channel.noteOn(midiNote, 60); // Play the note with velocity 60
                Thread.sleep(500);           // Wait for 500ms
                channel.noteOff(midiNote);   // Stop the note
            }
        }

        synthesizer.close();
    }

    public static int noteToMidi(String note) {
        String[] pitches = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        if (note.length() < 2 || note.length() > 3) return -1;

        String pitch = note.substring(0, note.length() - 1);
        char octaveChar = note.charAt(note.length() - 1);

        int pitchIndex = Arrays.asList(pitches).indexOf(pitch);
        int octave;

        try {
            octave = Integer.parseInt(String.valueOf(octaveChar));
        } catch (NumberFormatException e) {
            return -1;
        }

        if (pitchIndex == -1 || octave < 0 || octave > 9) return -1;

        return 12 * (octave + 1) + pitchIndex;
    }
}
