package HomeTask6.notes.infrastructure.persistance;

import HomeTask6.database.NotesDatabase;
import HomeTask6.database.NotesRecord;
import HomeTask6.notes.core.app.interfaces.INotesDatabaseContext;
import HomeTask6.notes.core.domain.Note;
import HomeTask6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements INotesDatabaseContext {
    public NotesDbContext(IDatabase database) {
        super(database);
    }

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }

        return notesList;
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}