package HomeTask1.ModelElements;

import java.util.List;

public class PolygonalModel {

    /**
     * Задаем полигональную модель как список многоугольников и текстур
     */
    private List<Polygon> polygons;
    private List<Texture> textures;

    public PolygonalModel(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public PolygonalModel(List<Polygon> polygons, List<Texture> textures) {
        this.polygons = polygons;
        this.textures = textures;
    }

    public void addPolygon(Polygon poly) {
        polygons.add(poly);
    }

    public void removePolygon(Polygon poly) {
        polygons.remove(poly);
    }

    public void addTexture(Texture texture) {
        textures.add(texture);
    }

    public void removeTexture(Texture texture) {
        textures.remove(texture);
    }

    public List<Polygon> getPolygons() {
        return this.polygons;
    }

    public List<Texture> getTextures() {
        return this.textures;
    }

}
