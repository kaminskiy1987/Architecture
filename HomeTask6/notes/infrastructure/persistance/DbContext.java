package HomeTask6.notes.infrastructure.persistance;

public abstract class DbContext {
    protected IDatabase database;

    public DbContext(IDatabase database) {
        this.database = database;
    }

    protected abstract void onModelCreating(ModelBuilder builder);

    public boolean saveChanges(){
        //TODO: Сохранение изменений в БД

        return true;
    }
}