package HomeTask6.notes.core.app.interfaces;

import HomeTask6.notes.core.domain.Note;

import java.util.Collection;

public interface INotesPresenter {
    void printAll(Collection<Note> notes);
}