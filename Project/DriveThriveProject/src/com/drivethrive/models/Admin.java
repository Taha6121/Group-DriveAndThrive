package com.drivethrive.models;

public class Admin extends User {
    public Admin(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("Rol: Sistem Yöneticisi (Admin) - " + getName());
    }
}