package com.example.tubespbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MahasiswaGUI extends JFrame {
    private Perpustakaan perpustakaan;
    private Mahasiswa mahasiswa;
    private JTextArea textArea;

    public MahasiswaGUI(Perpustakaan perpustakaan, Mahasiswa mahasiswa) {
        this.perpustakaan = perpustakaan;
        this.mahasiswa = mahasiswa;

        setTitle("Mahasiswa Dashboard");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 248, 220));

        JButton lihatBukuButton = new JButton("Lihat Daftar Buku", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\Book.png"));
        lihatBukuButton.setBounds(10, 10, 250, 50);
        panel.add(lihatBukuButton);

        JButton pinjamBukuButton = new JButton("Pinjam Buku", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\BorrowBook.png"));
        pinjamBukuButton.setBounds(270, 10, 250, 50);
        panel.add(pinjamBukuButton);

        JButton lihatBukuDipinjamButton = new JButton("Lihat Buku Dipinjam", new ImageIcon("C:\\Users\\Rifki\\Documents\\Intellij Java\\Perpus\\src\\main\\java\\com\\example\\image\\View.png"));
        lihatBukuDipinjamButton.setBounds(10, 70, 250, 50);
        panel.add(lihatBukuDipinjamButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(480, 10, 100, 50);
        panel.add(logoutButton);

        textArea = new JTextArea();
        textArea.setBounds(10, 130, 570, 320);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(textArea);

        lihatBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lihatDaftarBuku();
            }
        });

        pinjamBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinjamBuku();
            }
        });

        lihatBukuDipinjamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lihatBukuDipinjam();
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

    private void pinjamBuku() {
        String judul = JOptionPane.showInputDialog("Masukkan Judul Buku:");
        for (Buku buku : perpustakaan.getBukuList()) {
            if (buku.getJudul().equalsIgnoreCase(judul) && buku.getJumlah() > 0) {
                buku.kurangiJumlah();
                mahasiswa.pinjamBuku(buku);
                JOptionPane.showMessageDialog(null, "Buku berhasil dipinjam!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Buku tidak tersedia atau judul tidak ditemukan!");
    }

    private void lihatBukuDipinjam() {
        StringBuilder sb = new StringBuilder();
        for (Buku buku : mahasiswa.getBukuDipinjam()) {
            sb.append("Judul: ").append(buku.getJudul())
                    .append(", Penulis: ").append(buku.getPenulis())
                    .append(", Kategori: ").append(buku.getKategori())
                    .append("\n");
        }
        textArea.setText(sb.toString());
    }
}


