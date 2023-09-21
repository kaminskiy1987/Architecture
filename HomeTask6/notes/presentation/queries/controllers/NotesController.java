package HomeTask6.notes.presentation.queries.conrollers;

import HomeTask6.notes.core.app.interfaces.INoteEditor;
import HomeTask6.notes.core.domain.Note;

public class NotesController extends Controller {
    private final INoteEditor notesEditor;

    public NotesController(INoteEditor notesEditor) {
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note) {
        this.notesEditor.add(note);
    }

    public void routeRemoveNote(Note note) {
        this.notesEditor.remove(note);
    }

    public void routeGetAll() {
        this.notesEditor.printAll();
    }
}