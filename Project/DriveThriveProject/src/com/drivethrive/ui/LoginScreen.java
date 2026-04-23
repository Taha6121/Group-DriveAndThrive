package com.drivethrive.ui;

import com.drivethrive.models.User;
import com.drivethrive.models.Customer;
import com.drivethrive.models.Driver;
import com.drivethrive.models.Admin;
import com.drivethrive.services.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private AuthService authService;

    public LoginScreen() {
        authService = new AuthService();

        setTitle("Drive & Thrive - Giriş Sistemi");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridLayout(4, 2, 10, 10)); 

        add(new JLabel("   Kullanıcı Adı / Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("   Şifre:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Hesap Oluştur");
        add(registerButton);

        loginButton = new JButton("Giriş Yap");
        add(loginButton);

        // --- GİRİŞ YAP BUTONU ---
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String pass = new String(passwordField.getPassword());

                User loggedInUser = authService.authenticate(email, pass);

                if (loggedInUser != null) {
                    JOptionPane.showMessageDialog(null, "Hoşgeldin, " + loggedInUser.getName() + "!");
                    dispose(); // Giriş penceresini kapatır

                    // İŞTE SİHİR BURADA: KİM GİRDİYSE ONUN PENCERESİNİ AÇIYORUZ
                    if (loggedInUser instanceof Admin) {
                        AdminDashboard adminPanel = new AdminDashboard((Admin) loggedInUser);
                        adminPanel.setVisible(true);
                    } 
                    else if (loggedInUser instanceof Customer) {
                        CustomerDashboard customerPanel = new CustomerDashboard((Customer) loggedInUser);
                        customerPanel.setVisible(true);
                    } 
                    else if (loggedInUser instanceof Driver) {
                        DriverDashboard driverPanel = new DriverDashboard((Driver) loggedInUser);
                        driverPanel.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı email veya şifre!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // --- KAYIT OL BUTONU ---
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Girişi gizle
                RegisterScreen regScreen = new RegisterScreen(authService, LoginScreen.this);
                regScreen.setVisible(true); // Kayıt ekranını aç
            }
        });
    }
}