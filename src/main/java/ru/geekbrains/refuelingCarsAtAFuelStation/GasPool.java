package ru.geekbrains.refuelingCarsAtAFuelStation;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float maximumFuelTankVolume = 200F;
    private float currentFuelTankVolume = 200F;

    public float request(float amount) {
        lock.writeLock().lock();
        try {
            if (amount> currentFuelTankVolume){
                return 0F;
            }
            Thread.sleep(1500);
            currentFuelTankVolume -= amount;
            return amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return 0F;
    }

    @Override
    public String toString() {
        return "GasPool {" +
                "max Fuel =" + maximumFuelTankVolume +
                ", current fuel =" + currentFuelTankVolume +
                '}';
    }
}
