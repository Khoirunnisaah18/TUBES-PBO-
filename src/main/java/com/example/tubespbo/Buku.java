package com.example.tubespbo;

public class Buku {
    private String judul;
    private String penulis;
    private String kategori;
    private int lamaPeminjaman;
    private int jumlah;

    public Buku(String judul, String penulis, String kategori, int lamaPeminjaman, int jumlah) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.lamaPeminjaman = lamaPeminjaman;
        this.jumlah = jumlah;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public int getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void kurangiJumlah() {
        if (jumlah > 0) {
            jumlah--;
        }
    }
}

