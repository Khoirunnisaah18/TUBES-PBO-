package com.example.tubespbo;

import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    private String username;
    private String password;
    private String nama;
    private String nim;
    private String prodi;
    private String jurusan;
    private List<Buku> bukuDipinjam;

    public Mahasiswa(String username, String password, String nama, String nim, String prodi, String jurusan) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.jurusan = jurusan;
        this.bukuDipinjam = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getProdi() {
        return prodi;
    }

    public String getJurusan() {
        return jurusan;
    }

    public List<Buku> getBukuDipinjam() {
        return bukuDipinjam;
    }

    public void pinjamBuku(Buku buku) {
        bukuDipinjam.add(buku);
    }
}

