package Assignment6_4.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Tämä luokka hallinnoi kaikkia muistiinpanoja
public class Notebook {
    private ObservableList<Note> notes = FXCollections.observableArrayList(); // Lista muistiinpanoista

    // Lisää uusi muistiinpano listaan
    public void addNote(Note note) {
        notes.add(note);
    }

    // Palauttaa kaikki muistiinpanot
    public ObservableList<Note> getNotes() {
        return notes;
    }
}