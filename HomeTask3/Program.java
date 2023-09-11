package HomeTask3;

import HomeTask3.car.*;
import HomeTask3.carwashing.*;
import HomeTask3.gasstation.RefuelingStation;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        RefuelingStation refuelingStation1 = new RefuelingStation("AZS1");
        RefuelingStation refuelingStation2 = new RefuelingStation("AZS2");

        CarWash carWash1 = new CarWash("CarWash1");
        CarWash carWash2 = new CarWash("CarWash2");

        List<Car> garage = new ArrayList<>();
        garage.add(new Harvester("AAA", "A200", Color.GREEN, FuelType.DIESEL));
        garage.add(new Truck("BBB", "B320", Color.BLUE, FuelType.DIESEL));
        garage.add(new Sedan("CCC", "C241", Color.BLACK, FuelType.GASOLINE));
        garage.add(new Sportcar("DDD", "D567", Color.ORANGE, FuelType.GASOLINE));
        garage.add(new Pickup("EEE", "E150", Color.RED, FuelType.DIESEL));

        System.out.println("Заправляем авто:");

        for (Car car : garage) {
            System.out.println(car.getMake() + " " + car.getModel() + ":");

            if (garage.indexOf(car) % 2 == 0) {
                if (car instanceof IFuelable) {
                    ((IFuelable) car).setRefuelingStation(refuelingStation1);
                    ((IFuelable) car).getFuel();
                }
            } else {
                if (car instanceof IFuelable) {
                    ((IFuelable) car).setRefuelingStation(refuelingStation2);
                    ((IFuelable) car).getFuel();
                }
            }
            System.out.println("---------------------------");
        }
        System.out.println();
        System.out.println("Направляем автомобили на мойку:");

        for (Car car : garage) {
            System.out.println(car.getMake() + " " + car.getModel() + ":");

            if (garage.indexOf(car) % 2 == 0) {
                if (car instanceof IWash) {
                    ((IWash) car).setCarWash(carWash1);
                    ((IWash) car).wash("complex1");
                }
            } else {
                if (car instanceof IWash) {
                    ((IWash) car).setCarWash(carWash2);
                    ((IWash) car).wash("complex2");
                }
            }

            System.out.println("---------------------------");
        }
    }
}