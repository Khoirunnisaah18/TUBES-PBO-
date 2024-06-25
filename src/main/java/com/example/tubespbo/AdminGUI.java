package com.example.tubespbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private Perpustakaan perpustakaan;
    private JTextArea textArea;

    public AdminGUI(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;

        setTitle("Admin Dashboard");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255));

        JButton lihatMahasiswaButton = new JButton("Lihat Daftar Mahasiswa", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\View.png"));
        lihatMahasiswaButton.setBounds(10, 10, 250, 50);
        panel.add(lihatMahasiswaButton);

        JButton tambahMahasiswaButton = new JButton("Tambah Mahasiswa", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\Add.png"));
        tambahMahasiswaButton.setBounds(270, 10, 250, 50);
        panel.add(tambahMahasiswaButton);

        JButton tambahBukuButton = new JButton("Tambah Buku", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\Add.png"));
        tambahBukuButton.setBounds(10, 70, 250, 50);
        panel.add(tambahBukuButton);

        JButton lihatBukuButton = new JButton("Lihat Daftar Buku", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\Book.png"));
        lihatBukuButton.setBounds(270, 70, 250, 50);
        panel.add(lihatBukuButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(530, 10, 150, 50);
        panel.add(logoutButton);

        textArea = new JTextArea();
        textArea.setBounds(10, 130, 670, 420);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(textArea);

        lihatMahasiswaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lihatDaftarMahasiswa();
            }
        });

        tambahMahasiswaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahMahasiswa();
            }
        });

        tambahBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahBuku();
            }
        });

        lihatBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lihatDaftarBuku();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGUI();
                dispose();
            }
        });

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void lihatDaftarMahasiswa() {
        StringBuilder sb = new StringBuilder();
        for (Mahasiswa mahasiswa : perpustakaan.getMahasiswas()) {
            sb.append("Nama: ").append(mahasiswa.getNama())
                    .append(", NIM: ").append(mahasiswa.getNim())
                    .append(", Fakultas: ").append(mahasiswa.getProdi())
                    .append(", Jurusan: ").append(mahasiswa.getJurusan())
                    .append("\n");
        }
        textArea.setText(sb.toString());
    }

    private void tambahMahasiswa() {
        JTextField usernameField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JTextField namaField = new JTextField(20);
        JTextField nimField = new JTextField(20);
        JTextField prodiField = new JTextField(20);
        JTextField jurusanField = new JTextField(20);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Nama:"));
        panel.add(namaField);
        panel.add(new JLabel("NIM:"));
        panel.add(nimField);
        panel.add(new JLabel("Fakultas:"));
        panel.add(prodiField);
        panel.add(new JLabel("Jurusan:"));
        panel.add(jurusanField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Tambah Mahasiswa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String nama = namaField.getText();
            String nim = nimField.getText();
            String prodi = prodiField.getText();
            String jurusan = jurusanField.getText();

            Mahasiswa mahasiswa = new Mahasiswa(username, password, nama, nim, prodi, jurusan);
            perpustakaan.tambahMahasiswa(mahasiswa);
            JOptionPane.showMessageDialog(null, "Mahasiswa berhasil ditambahkan!");
        }
    }

    private void tambahBuku() {
        JTextField judulField = new JTextField(20);
        JTextField penulisField = new JTextField(20);
        JTextField kategoriField = new JTextField(20);
        JTextField lamaPeminjamanField = new JTextField(20);
        JTextField jumlahField = new JTextField(20);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Judul:"));
        panel.add(judulField);
        panel.add(new JLabel("Penulis:"));
        panel.add(penulisField);
        panel.add(new JLabel("Kategori:"));
        panel.add(kategoriField);
        panel.add(new JLabel("Lama Peminjaman:"));
        panel.add(lamaPeminjamanField);
        panel.add(new JLabel("Jumlah:"));
        panel.add(jumlahField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Tambah Buku", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            String kategori = kategoriField.getText();
            int lamaPeminjaman = Integer.parseInt(lamaPeminjamanField.getText());
            int jumlah = Integer.parseInt(jumlahField.getText());
            perpustakaan.tambahBuku(new Buku(judul, penulis, kategori, lamaPeminjaman, jumlah));
            JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan!");
        }
    }

    private void lihatDaftarBuku() {
        StringBuilder sb = new StringBuilder();
        for (Buku buku : perpustakaan.getBukuList()) {
            sb.append("Judul: ").append(buku.getJudul())
                    .append(", Penulis: ").append(buku.getPenulis())
                    .append(", Kategori: ").append(buku.getKategori())
                    .append(", Lama Peminjaman: ").append(buku.getLamaPeminjaman())
                    .append(" hari, Tersedia: ").append(buku.getJumlah())
                    .append("\n");
        }
        textArea.setText(sb.toString());
    }
}


