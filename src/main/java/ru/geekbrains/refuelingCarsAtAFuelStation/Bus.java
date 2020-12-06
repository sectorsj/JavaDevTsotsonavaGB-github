package ru.geekbrains.refuelingCarsAtAFuelStation;

public class Bus implements Vehicle, Runnable {
    private String identificationNumber;
    private final float maximumFuelTankVolume = 40F;
    private float currentFuelTankVolume = 40F;
    private float fuelConsumption = 7.5F;
    private FuelStation fuelStation;

    public Bus(String identificationNumber, FuelStation fuelStation) {
        this.identificationNumber = identificationNumber;
        this.fuelStation = fuelStation;
    }

    public void drive() {
        System.out.println(String.format("[%s] is on the road....", identificationNumber));
        try {
            while (currentFuelTankVolume > 3) {
                Thread.sleep(3000);
                currentFuelTankVolume -= fuelConsumption;
                System.out.println(String.format("[%s] remaining fuel %s...", identificationNumber, currentFuelTankVolume));
            }
            System.out.println(String.format("[%s] has not enough fuel %s...", identificationNumber, currentFuelTankVolume));
            float refuelAVehicle = fuelStation.refuel(maximumFuelTankVolume - currentFuelTankVolume);
            if (refuelAVehicle == 0F) {
                System.out.println(String.format("[%s] is stuck without fuel....", identificationNumber));
                return;
            }
            currentFuelTankVolume += refuelAVehicle;
            drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        drive();
    }
}
