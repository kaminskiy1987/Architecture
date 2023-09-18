package HomeTask5.entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 3D модель
 */
public class Model3D implements Entity {
    private static int counter = 10000;
    private int id;

    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    public Model3D() {
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    public void addTexture(Texture texture) {
        this.textures.add(texture);
    }

    public void removeTexture(Texture texture) {
        this.textures.remove(texture);
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }
}