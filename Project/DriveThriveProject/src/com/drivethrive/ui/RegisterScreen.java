package com.drivethrive.ui;

import com.drivethrive.models.Customer;
import com.drivethrive.models.Driver;
import com.drivethrive.services.AuthService;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class RegisterScreen extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JButton registerButton;
    private JButton backButton;

    private AuthService authService;
    private LoginScreen loginScreen; // Geri dönmek için login ekranını hafızada tutuyoruz

    public RegisterScreen(AuthService authService, LoginScreen loginScreen) {
        this.authService = authService;
        this.loginScreen = loginScreen;

        setTitle("Drive & Thrive - Yeni Kayıt Oluştur");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Ekran ortasında aç
        setLayout(new GridLayout(5, 2, 10, 10));

        // Form Elemanları
        add(new JLabel("   Ad Soyad:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("   Email (Kullanıcı Adı):"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("   Şifre:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("   Hesap Türü:"));
        String[] roles = {"Müşteri", "Şoför"}; // Admin dışarıdan kayıt olamaz!
        roleBox = new JComboBox<>(roles);
        add(roleBox);

        backButton = new JButton("Geri Dön");
        add(backButton);

        registerButton = new JButton("Kayıt Ol");
        add(registerButton);

        // --- BUTON AKSİYONLARI ---

        // Geri Dön Butonu
        backButton.addActionListener(e -> {
            dispose(); // Kayıt ekranını kapat
            loginScreen.setVisible(true); // Login ekranını tekrar göster
        });

        // Kayıt Ol Butonu
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            String role = (String) roleBox.getSelectedItem();

            // Boş alan kontrolü
            if(name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Rastgele ID oluştur (Gerçek DB gelene kadar id'leri böyle atıyoruz)
            String newId = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            boolean success = false;

            // Seçilen role göre nesne oluştur ve kaydet
            if (role.equals("Müşteri")) {
                success = authService.registerUser(new Customer("C-" + newId, name, email), pass);
            } else if (role.equals("Şoför")) {
                success = authService.registerUser(new Driver("D-" + newId, name, email, "B-Sınıfı"), pass);
            }

            if (success) {
                JOptionPane.showMessageDialog(null, "Kayıt Başarılı! Artık giriş yapabilirsiniz.");
                dispose();
                loginScreen.setVisible(true); // Girişe geri dön
            } else {
                JOptionPane.showMessageDialog(null, "Bu email zaten sistemde kayıtlı!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}