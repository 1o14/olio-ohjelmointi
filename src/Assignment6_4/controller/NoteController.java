package Assignment6_4.controller;

import Assignment6_4.model.Note;
import Assignment6_4.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NoteController {
    @FXML private TextField titleField;  // Otsikon syöttökenttä
    @FXML private TextArea contentArea; // Sisällön syöttökenttä
    @FXML private Button addButton;  // Lisää-nappi
    @FXML private Button updateButton; // Päivitä-nappi
    @FXML private Button deleteButton; // Poista-nappi
    @FXML private ListView<Note> notesList; // Lista, jossa näkyvät muistiinpanot

    private Notebook notebook = new Notebook(); // Muistikirja-olio
    private Note selectedNote = null; // Valittu muistiinpano

    @FXML
    public void initialize() {
        // Yhdistetään ListView muistikirjaan
        notesList.setItems(notebook.getNotes());

        // Napin tapahtumat
        addButton.setOnAction(event -> addNote());
        updateButton.setOnAction(event -> updateNote());
        deleteButton.setOnAction(event -> deleteNote());

        // Kun käyttäjä klikkaa ListView:n muistiinpanoa
        notesList.setOnMouseClicked(this::selectNote);
    }

    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        // Lisätään muistiinpano vain jos kentät eivät ole tyhjiä
        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note); // Lisätään muistikirjaan

            // Tyhjennetään tekstikentät
            titleField.clear();
            contentArea.clear();
        }
    }

    private void selectNote(MouseEvent event) {
        // Kun käyttäjä klikkaa muistiinpanoa, se näkyy syötekentissä
        selectedNote = notesList.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            titleField.setText(selectedNote.getTitle());
            contentArea.setText(selectedNote.getContent());
        }
    }

    private void updateNote() {
        if (selectedNote != null) {
            // Päivitetään valitun muistiinpanon tiedot
            selectedNote.setTitle(titleField.getText());
            selectedNote.setContent(contentArea.getText());

            // Päivitetään ListView
            notesList.refresh();
        }
    }

    private void deleteNote() {
        if (selectedNote != null) {
            // Poistetaan muistiinpano muistikirjasta
            notebook.getNotes().remove(selectedNote);
            selectedNote = null;

            // Tyhjennetään syötekentät
            titleField.clear();
            contentArea.clear();
        }
    }
}
