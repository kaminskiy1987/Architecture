package HomeTask1;

import HomeTask1.InMemoryModel.ModelStore;
import HomeTask1.InMemoryModel.Observer1;
import HomeTask1.InMemoryModel.Observer2;
import HomeTask1.ModelElements.*;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        ModelStore store = new ModelStore();
        store.RegisterModelChanger(observer1);
        store.RegisterModelChanger(observer2);

        Polygon p1 = new Polygon();
        List<Polygon> polygons = new ArrayList<>();
        polygons.add(p1);
        PolygonalModel polygonalModel = new PolygonalModel(polygons);
        store.addModel(polygonalModel);

        Camera cam1 = new Camera(new Point3D(3, 3, 3), new Angle3D(135, -30, 0));
        List<Camera> cameras = new ArrayList<>();
        cameras.add(cam1);
        store.addCamera(cam1);
    }

}