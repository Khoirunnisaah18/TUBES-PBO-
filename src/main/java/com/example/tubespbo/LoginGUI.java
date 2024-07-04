package com.example.tubespbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JComboBox<String> userTypeBox;
    private Perpustakaan perpustakaan;

    public LoginGUI() {
        perpustakaan = new Perpustakaan();
        perpustakaan.tambahAdmin(new Admin("admin", "admin"));
        perpustakaan.tambahMahasiswa(new Mahasiswa("student", "student", "Nama", "123456", "Prodi", "Jurusan"));

        setTitle("Login Perpustakaan");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel panel = new JPanel();
        panel.setLayout(null); // Menggunakan layout nul

        // Username Label dan Field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(100, 120, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 120, 200, 25); // Menyesuaikan ukuran sesuai keinginan
        panel.add(usernameField);

        // Password Label dan Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 150, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 150, 200, 25); // Menyesuaikan ukuran sesuai keinginan
        panel.add(passwordField);

        // UserType Label dan ComboBox
        JLabel userTypeLabel = new JLabel("Login as:");
        userTypeLabel.setBounds(100, 180, 80, 25);
        panel.add(userTypeLabel);

        userTypeBox = new JComboBox<>(new String[]{"Admin", "Mahasiswa"});
        userTypeBox.setBounds(180, 180, 200, 25);
        panel.add(userTypeBox);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(200, 220, 100, 30);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeBox.getSelectedItem();

                if (userType.equals("Admin")) {
                    Admin admin = perpustakaan.loginAdmin(username, password);
                    if (admin != null) {
                        new AdminGUI(perpustakaan);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Admin Gagal!");
                    }
                } else {
                    Mahasiswa mahasiswa = perpustakaan.loginMahasiswa(username, password);
                    if (mahasiswa != null) {
                        new MahasiswaGUI(perpustakaan, mahasiswa);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Mahasiswa Gagal!");
                    }
                }
            }
        });

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}


