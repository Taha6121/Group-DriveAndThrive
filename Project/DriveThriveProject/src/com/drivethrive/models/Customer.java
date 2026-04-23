package com.drivethrive.models;

public class Customer extends User {
    private boolean hasActiveBooking;

    public Customer(String id, String name, String email) {
        super(id, name, email);
        this.hasActiveBooking = false;
    }

    public boolean hasActiveBooking() { return hasActiveBooking; }
    public void setHasActiveBooking(boolean status) { this.hasActiveBooking = status; }

    @Override
    public void displayRole() {
        System.out.println("Rol: Müşteri - " + getName());
    }
}