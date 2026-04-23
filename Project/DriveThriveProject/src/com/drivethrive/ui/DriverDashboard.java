package com.drivethrive.ui;

import com.drivethrive.models.Driver;
import javax.swing.*;
import java.awt.*;

public class DriverDashboard extends JFrame {
    private Driver loggedInDriver;

    public DriverDashboard(Driver driver) {
        this.loggedInDriver = driver;

        setTitle("Drive & Thrive - Şoför Paneli");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("İyi Mesailer, Kaptan " + driver.getName(), SwingConstants.CENTER);
        add(welcomeLabel);

        JLabel statusLabel = new JLabel("Şu anki durumunuz: " + (driver.isAvailable() ? "MÜSAİT" : "MEŞGUL"), SwingConstants.CENTER);
        add(statusLabel);

        JButton toggleStatusButton = new JButton("Durumumu Değiştir");
        toggleStatusButton.addActionListener(e -> {
            loggedInDriver.setAvailable(!loggedInDriver.isAvailable());
            statusLabel.setText("Şu anki durumunuz: " + (loggedInDriver.isAvailable() ? "MÜSAİT" : "MEŞGUL"));
        });
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(toggleStatusButton);
        add(btnPanel);
    }
}