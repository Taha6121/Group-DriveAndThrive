package com.drivethrive.models;

public abstract class Vehicle {
    private String plateNumber;
    private double baseDailyPrice;
    private boolean isAvailable; 

    public Vehicle(String plateNumber, double baseDailyPrice) {
        this.plateNumber = plateNumber;
        this.baseDailyPrice = baseDailyPrice;
        this.isAvailable = true; 
    }

    public String getPlateNumber() { return plateNumber; }
    public double getBaseDailyPrice() { return baseDailyPrice; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public abstract double calculateRentalCost(int days);
}