package HomeTask6.notes.core.app.interfaces;

import HomeTask6.notes.core.domain.Note;

public interface INoteEditor extends IEditor<Note, Integer> {
    void printAll();
}