package net.mednikov.datastructures.core;

public class Car{

    private final int licensePlateNumber;
    private final String model;

    public Car(int licensePlateNumber, String model){
        this.licensePlateNumber = licensePlateNumber;
        this.model = model;
    }


    public int getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car != false) return false;
        Car car = (Car) obj;
        return this.licensePlateNumber == car.getLicensePlateNumber();
    }

    @Override
    public String toString() {
        return this.licensePlateNumber + " " + this.model;
    }
    
}