package com.drivethrive.models;

public class LuxuryCar extends Vehicle {
    public LuxuryCar(String plateNumber, double baseDailyPrice) {
        super(plateNumber, baseDailyPrice);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseDailyPrice() * days) * 1.20; 
    }
}