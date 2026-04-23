package com.drivethrive.models;

public class StandardCar extends Vehicle {
    public StandardCar(String plateNumber, double baseDailyPrice) {
        super(plateNumber, baseDailyPrice);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseDailyPrice() * days;
    }
}