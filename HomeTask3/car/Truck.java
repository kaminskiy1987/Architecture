package HomeTask3.car;

import HomeTask3.carwashing.CarWash;
import HomeTask3.gasstation.IRefuelable;

public class Truck extends Car implements IFuelable, IWash {
    private IRefuelable refueling;
    private CarWash carWash;

    public Truck(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        setWheelsCount(6);
    }

    @Override
    public void move() {
        System.out.println("Выпустив облако гари, грузовик начал движение... где-то вздохнула Грета Тумберг");
    }

    @Override
    public void maintenance() {
        System.out.println("Техобслуживание автомобиля выполнено");
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    @Override
    public void getFuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void setRefuelingStation(IRefuelable refuelingStation) {
        this.refueling = refuelingStation;
    }

    @Override
    public void wash(String complex) {
        if (carWash != null) {
            carWash.chooseComplex(complex);
        }
    }

    @Override
    public void setCarWash(CarWash carWash) {
        this.carWash = carWash;
    }
}