package HomeTask6.database;

import HomeTask6.notes.infrastructure.persistance.IDatabase;

public class NotesDatabase implements IDatabase {
    private NotesTable notesTable;

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }
}