package com.drivethrive.models;

public class Driver extends User {
    private String licenseType;
    private boolean isAvailable; 

    public Driver(String id, String name, String email, String licenseType) {
        super(id, name, email);
        this.licenseType = licenseType;
        this.isAvailable = true; 
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public void displayRole() {
        System.out.println("Rol: Profesyonel Şoför - " + getName());
    }
}