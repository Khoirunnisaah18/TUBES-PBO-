package com.example.tubespbo;

import javax.swing.*;

public class ErrorHandler {
    public static void handleError(Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
