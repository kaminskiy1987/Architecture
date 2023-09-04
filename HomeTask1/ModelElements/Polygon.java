package HomeTask1.ModelElements;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    /**
     * Задаем многоугольник как список точек в 3D пространстве
     */
    private List<Point3D> points;

    public Polygon(List<Point3D> points) {
        this.points = points;
    }

    public Polygon() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point3D point) {
        points.add(point);
    }

    public void removePoint(Point3D point) {
        points.remove(point);
    }

    public List<Point3D> getPolygon() {
        return this.points;
    }

}