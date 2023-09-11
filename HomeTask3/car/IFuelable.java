package HomeTask3.car;

import HomeTask3.gasstation.IRefuelable;

public interface IFuelable {
    // заправить автомобиль
    void getFuel();

    // назначить автозаправку
    void setRefuelingStation(IRefuelable refuelingStation);
}