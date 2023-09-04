package HomeTask1.InMemoryModel;

import HomeTask1.ModelElements.Camera;
import HomeTask1.ModelElements.Flash;
import HomeTask1.ModelElements.PolygonalModel;
import HomeTask1.ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {

    private List<IModelChangedObserver> observers = new ArrayList<>();

    private List<PolygonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();

    /*
     * Метод добавляет полигональную модель в хранилище моделей и оповещает об
     * изменении
     */
    public void addModel(PolygonalModel model) {
        models.add(model);
        notifyChange();
    }

    /*
     * Метод удаляет указанную в качестве параметра модель из хранилища и оповещает
     * об изменении
     */
    public void removeModel(PolygonalModel model) {
        models.remove(model);
        notifyChange();
    }

    /*
     * Метод добавляет источник света в хранилище источников света и оповещает об
     * изменении
     */
    public void addFlash(Flash flash) {
        flashes.add(flash);
        notifyChange();
    }

    /*
     * Метод удаляет указанный в качестве параметра источник света из хранилища и
     * оповещает об изменении
     */
    public void removeFlash(Flash flash) {
        flashes.remove(flash);
        notifyChange();
    }

    /*
     * Метод добавляет камеру в хранилище камер и оповещает об изменении
     */
    public void addCamera(Camera cam) {
        cameras.add(cam);
        notifyChange();
    }

    /*
     * Метод удаляет указанную в качестве параметра камеру из хранилища и оповещает
     * об изменении
     */
    public void removeCamera(Camera cam) {
        cameras.remove(cam);
        notifyChange();
    }

    /*
     * Метод добавляет сцену в хранилище сцен и оповещает об изменении
     */
    public void addScene(Scene scene) {
        scenes.add(scene);
        notifyChange();
    }

    /*
     * Метод удаляет указанную в качестве параметра сцену из хранилища и оповещает
     * об изменении
     */
    public void removeScene(Scene scene) {
        scenes.remove(scene);
        notifyChange();
    }

    /*
     * Метод удаляет получить из хранилища сцену по ее индексу
     */
    public Scene getScene(int index) {
        if (index >= 0 && index < scenes.size()) {
            return scenes.get(index);
        } else {
            throw new RuntimeException("Error: there is no scene at index " + index);
        }
    }

    /*
     * Метод оповещает все подписанные сервисы о произошедших изменениях
     */
    @Override
    public void notifyChange() {
        for (IModelChangedObserver observer : observers) {
            observer.applyUpdateModel();
        }
    }

    /*
     * Метод добавляет новый сервис в список оповещения о произошедших изменениях
     */
    @Override
    public void RegisterModelChanger(IModelChangedObserver observer) {
        observers.add(observer);
    }

    /*
     * Метод удаляет указанных в качестве параметра сервис из списка оповещения об
     * изменениях
     */
    @Override
    public void RemoveModelChanger(IModelChangedObserver observer) {
        observers.remove(observer);
    }

}
