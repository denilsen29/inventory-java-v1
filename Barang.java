// Barang.java

public class Barang {
    private String kode;
    private String nama;
    private int stok;
    private double harga;

    // Constructor
    public Barang(String kode, String nama, int stok, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    // Getter dan Setter
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Stok: " + stok + ", Harga: Rp" + harga;
    }
}