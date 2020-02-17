package net.mednikov.datastructures.core;

public class FuelableCar extends Car{

    private int fuel;

    public FuelableCar(int licensePlateNumber, String model, int fuel){
        super(licensePlateNumber, model);
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return super.toString() + " fuel level: " + fuel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FuelableCar == false) return false;
        FuelableCar car = (FuelableCar) obj;
        return this.getLicensePlateNumber() == car.getLicensePlateNumber();
    }
}