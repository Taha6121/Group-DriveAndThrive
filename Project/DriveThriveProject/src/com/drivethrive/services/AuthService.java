package com.drivethrive.services;

import com.drivethrive.models.Admin;
import com.drivethrive.models.Customer;
import com.drivethrive.models.Driver;
import com.drivethrive.models.User;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    
    // Geçici Sanal Veri Tabanı (RAM'de tutar)
    private Map<String, User> users = new HashMap<>();
    private Map<String, String> passwords = new HashMap<>();

    public AuthService() {
        // Sistem ilk açıldığında varsayılan kullanıcıları otomatik ekleyelim
        registerUser(new Admin("A01", "Sistem Yöneticisi", "admin"), "1234");
        registerUser(new Customer("C01", "Ahmet Müşteri", "musteri"), "1234");
        registerUser(new Driver("D01", "Mehmet Kaptan", "sofor", "B-Sınıfı"), "1234");
    }

    // YENİ ÖZELLİK: Sisteme yeni kullanıcı kaydetme metodu
    public boolean registerUser(User user, String password) {
        if (users.containsKey(user.getEmail())) {
            return false; // Bu email zaten kayıtlı!
        }
        users.put(user.getEmail(), user);
        passwords.put(user.getEmail(), password);
        return true;
    }

    // GÜNCELLENDİ: Artık sanal veri tabanından kontrol ediyor
    public User authenticate(String email, String password) {
        if (users.containsKey(email) && passwords.get(email).equals(password)) {
            return users.get(email);
        }
        return null; // Hatalı giriş
    }
}