package HomeTask3.car;

import HomeTask3.carwashing.CarWash;
import HomeTask3.gasstation.IRefuelable;

public class Sportcar extends Car implements IFuelable, IWash {
    private IRefuelable refueling;
    private CarWash carWash;

    public Sportcar(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        setWheelsCount(3);
    }

    @Override
    public void move() {
        System.out.println("Спорткар помчался");
    }

    @Override
    public void maintenance() {
        System.out.println("Обслуживание спорткара выполнено");
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

    /**
     * Назначить автомойку
     */
    public void setCarWash(CarWash carWash) {
        this.carWash = carWash;
    }

    /**
     * Назначить автозаправку
     */
    public void setRefuelingStation(IRefuelable refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void getFuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void wash(String complex) {
        if (carWash != null) {
            carWash.chooseComplex(complex);
        }
    }
}