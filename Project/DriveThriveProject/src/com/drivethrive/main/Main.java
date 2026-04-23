package com.drivethrive.main;

import com.drivethrive.ui.LoginScreen;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen login = new LoginScreen();
                login.setVisible(true); 
            }
        });
    }
}