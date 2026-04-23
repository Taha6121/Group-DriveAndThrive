package com.drivethrive.services;

import com.drivethrive.models.Customer;
import com.drivethrive.models.Driver;
import com.drivethrive.models.Vehicle;

public class BookingManager {

    public double calculateTaxiFare(double kilometers) {
        double baseFare = 50.0; 
        double perKmRate = 25.0; 
        return baseFare + (kilometers * perKmRate);
    }

    public double calculateRentalFare(double dailyCarPrice, int days, boolean wantsDriver) {
        double total = dailyCarPrice * days;
        if (wantsDriver) {
            total += (800 * days); 
        }
        return total;
    }

    public boolean createBooking(Customer customer, Vehicle vehicle, Driver optionalDriver, int days) {
        if (!vehicle.isAvailable()) return false;
        
        if (optionalDriver != null) {
            if (!optionalDriver.isAvailable()) return false;
            optionalDriver.setAvailable(false);
        }

        vehicle.setAvailable(false);
        customer.setHasActiveBooking(true);
        return true;
    }
}