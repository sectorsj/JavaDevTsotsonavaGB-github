package ru.geekbrains.refuelingCarsAtAFuelStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClassRCAAFS {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Car("Car #1 - e324rr 01", fuelStation));
        executorService.submit(new Car("Car #2 - a002tg 03", fuelStation));
        executorService.submit(new Car("Car #3 - b123gs 05", fuelStation));
        executorService.submit(new Car("Car #4 - c999er 03", fuelStation));

        executorService.submit(new Truck("Truck #1 - RA 1234 01", fuelStation));
        executorService.submit(new Truck("Truck #2 - HF 0001 02", fuelStation));
        executorService.submit(new Truck("Truck #3 - VC 4532 04", fuelStation));
        executorService.submit(new Truck("Truck #4 - GG 8862 01", fuelStation));

        executorService.submit(new Bus("Bus #1 - e213rf 01", fuelStation));
        executorService.submit(new Bus("Bus #2 - a564fd 13", fuelStation));
        executorService.submit(new Bus("Bus #3 - b765fd 33", fuelStation));
        executorService.submit(new Bus("Bus #4 - c432ew 12", fuelStation));

        executorService.shutdown();
    }
}
