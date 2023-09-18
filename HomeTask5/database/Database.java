package HomeTask5.database;

import HomeTask5.entity.Entity;
import HomeTask5.entity.Model3D;
import HomeTask5.entity.Texture;

import java.util.Collection;

/**
 * Интерфейс БД
 */
public interface Database {

    void load();

    void save();

    Collection<Entity> getAll();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void addTextureToModel(Model3D model, Texture texture);

    void removeTextureFromModel(Model3D model, Texture texture);
}