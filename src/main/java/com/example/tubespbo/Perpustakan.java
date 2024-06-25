package com.example.tubespbo;

import java.util.ArrayList;
import java.util.List;

class Perpustakaan {
    private List<Admin> admins;
    private List<Mahasiswa> mahasiswas;
    private List<Buku> bukuList;

    public Perpustakaan() {
        admins = new ArrayList<>();
        mahasiswas = new ArrayList<>();
        bukuList = new ArrayList<>();
    }

    public void tambahAdmin(Admin admin) {
        admins.add(admin);
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        mahasiswas.add(mahasiswa);
    }

    public void tambahBuku(Buku buku) {
        bukuList.add(buku);
    }

    public Admin loginAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public Mahasiswa loginMahasiswa(String username, String password) {
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.getUsername().equals(username) && mahasiswa.getPassword().equals(password)) {
                return mahasiswa;
            }
        }
        return null;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public List<Buku> getBukuList() {
        return bukuList;
    }
}

