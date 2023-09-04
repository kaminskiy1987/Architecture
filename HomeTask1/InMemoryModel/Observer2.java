package HomeTask1.InMemoryModel;

public class Observer2 implements IModelChangedObserver {

    @Override
    public void applyUpdateModel() {
        System.out.println("Была добавлена новая камера - observer #2");
    }

}
