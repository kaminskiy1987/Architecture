package HomeTask1.ModelElements;

import java.util.List;
import java.util.ArrayList;

public class Scene {

    /**
     * Задаем сцену как список полигональных моделей, источников света и камер
     */
    private List<PolygonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;

    public Scene() {
        models = new ArrayList<>();
        flashes = new ArrayList<>();
        cameras = new ArrayList<>();
    }

    public void addModel(List<Polygon> polygons) {
        models.add(new PolygonalModel(polygons));
    }

    public void removeModel(int index) {
        if (index >= 0 && index < models.size()) {
            models.remove(models.get(index));
        }
    }

    public void addFlash(Point3D location, Angle3D angle, Color color, Float power) {
        flashes.add(new Flash(location, angle, color, power));
    }

    public void removeFlash(int index) {
        if (index >= 0 && index < flashes.size()) {
            flashes.remove(flashes.get(index));
        }
    }

    public void editFlash(Integer index, Point3D location, Angle3D angle, Color color, Float power) {
        if (index >= 0 && index < flashes.size()) {
            if (location != null) {
                flashes.get(index).move(location);
            }
            if (angle != null) {
                flashes.get(index).rotate(angle);
            }
            if (color != null) {
                flashes.get(index).setColor(color);
            }
            if (angle != null) {
                flashes.get(index).setPower(power);
            }
        } else {
            throw new RuntimeException("Error: there is no flash at index " + index);
        }
    }

    public void addCamera(Point3D location, Angle3D angle) {
        cameras.add(new Camera(location, angle));
    }

    public void removeCamera(int index) {
        if (index >= 0 && index < cameras.size()) {
            cameras.remove(cameras.get(index));
        }
    }

    public void editCamera(int index, Point3D location, Angle3D angle) {
        if (index >= 0 && index < cameras.size()) {
            if (location != null) {
                cameras.get(index).move(location);
            }
            if (angle != null) {
                cameras.get(index).rotate(angle);
            }
        } else {
            throw new RuntimeException("Error: there is no camera at index " + index);
        }
    }

    public List<PolygonalModel> getModels() {
        return this.models;
    }

    public List<Flash> getFlashes() {
        return this.flashes;
    }

    public List<Camera> getCameras() {
        return this.cameras;
    }

}
