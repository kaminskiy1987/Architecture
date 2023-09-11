package HomeTask3.carwashing;

import HomeTask3.car.Car;

public class CarWash implements IWashable, IWipable {
    private String name;

    public CarWash(String name) {
        this.name = name;
    }

    public void chooseComplex(String complex) {
        switch (complex) {
            case "complex1": {
                wash();
                break;
            }
            case "complex2": {
                wash();
                wipWindshield();
                wipMirrors();
                wipHeadlights();
                break;
            }
        }
    }

    @Override
    public void wash() {
        System.out.println(name + ": Автомобиль помыт");
    }

    @Override
    public void wipMirrors() {
        System.out.println(name + ": Выполнена протирка боковых зеркал");
    }

    @Override
    public void wipWindshield() {
        System.out.println(name + ": Выполнена протирка лобового стекла");
    }

    @Override
    public void wipHeadlights() {
        System.out.println(name + ": Выполнена протирка фар");
    }
}