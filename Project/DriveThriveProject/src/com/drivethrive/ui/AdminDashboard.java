package com.drivethrive.ui;

import com.drivethrive.models.Admin;
import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    private Admin loggedInAdmin;

    public AdminDashboard(Admin admin) {
        this.loggedInAdmin = admin;

        setTitle("Drive & Thrive - Sistem Yönetim Merkezi");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Yetkili Girişi: " + admin.getName(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel actionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        actionPanel.add(new JButton("Tüm Araçları Gör"));
        actionPanel.add(new JButton("Şoförleri Denetle"));
        actionPanel.add(new JButton("Aktif Rezervasyonlar"));
        actionPanel.add(new JButton("Sistem Raporu Al"));
        
        add(actionPanel, BorderLayout.CENTER);
    }
}