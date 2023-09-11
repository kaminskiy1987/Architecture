package HomeTask3.gasstation;

import HomeTask3.car.FuelType;

public interface IRefuelable {
    /**
     * Заправка
     */
    void fuel(FuelType fuelType);
}