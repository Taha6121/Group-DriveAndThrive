package com.drivethrive.ui;

import com.drivethrive.models.Customer;
import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {
    private Customer loggedInCustomer;

    public CustomerDashboard(Customer customer) {
        this.loggedInCustomer = customer;

        setTitle("Drive & Thrive - Müşteri Paneli");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Kapatınca program dursun
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("Hoşgeldin, " + customer.getName() + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel);

        JButton taxiButton = new JButton("Taksi Çağır (KM Bazlı)");
        JButton rentButton = new JButton("Araç Kirala (Gün Bazlı)");

        // Taksi butonu aksiyonu
        taxiButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Taksi çağırma ekranı yakında eklenecek...");
        });

        // Kiralama butonu aksiyonu
        rentButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Araç kiralama ekranı yakında eklenecek...");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(taxiButton);
        buttonPanel.add(rentButton);
        add(buttonPanel);
    }
}