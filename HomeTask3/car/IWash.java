package HomeTask3.car;

import HomeTask3.carwashing.CarWash;

public interface IWash {
    // помыть автомобиль
    void wash(String complex);

    // назначить автомойку
    void setCarWash(CarWash carWash);
}