package HomeTask5.dac;

import HomeTask5.database.Database;
import HomeTask5.entity.Entity;
import HomeTask5.entity.Model3D;
import HomeTask5.entity.Texture;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Реализация DAC
 */
public class EditorDatabaseAccess implements DatabaseAccess {
    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                models.add((Texture) entity);
            }
        }
        return models;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public void addTextureTo(Model3D model3D, Texture texture) {
        editorDatabase.addTextureToModel(model3D, texture);
    }

    @Override
    public void delTextureFrom(Model3D model3D, Texture texture) {
        editorDatabase.removeTextureFromModel(model3D, texture);
    }
}