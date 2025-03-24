// ManajemenStokBarang.java

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenStokBarang {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Manajemen Stok Barang ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    lihatDaftarBarang();
                    break;
                case 3:
                    updateBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahBarang() {
        System.out.print("Masukkan kode barang: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan stok barang: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan harga barang: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan newline

        Barang barang = new Barang(kode, nama, stok, harga);
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void lihatDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.println("\nDaftar Barang:");
            for (Barang barang : daftarBarang) {
                System.out.println(barang);
            }
        }
    }

    private static void updateBarang() {
        System.out.print("Masukkan kode barang yang akan diupdate: ");
        String kode = scanner.nextLine();
        Barang barang = cariBarangByKode(kode);

        if (barang != null) {
            System.out.print("Masukkan stok baru: ");
            int stok = scanner.nextInt();
            System.out.print("Masukkan harga baru: ");
            double harga = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan newline

            barang.setStok(stok);
            barang.setHarga(harga);
            System.out.println("Barang berhasil diupdate!");
        } else {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
        }
    }

    private static void hapusBarang() {
        System.out.print("Masukkan kode barang yang akan dihapus: ");
        String kode = scanner.nextLine();
        Barang barang = cariBarangByKode(kode);

        if (barang != null) {
            daftarBarang.remove(barang);
            System.out.println("Barang berhasil dihapus!");
        } else {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
        }
    }

    private static Barang cariBarangByKode(String kode) {
        for (Barang barang : daftarBarang) {
            if (barang.getKode().equalsIgnoreCase(kode)) {
                return barang;
            }
        }
        return null;
    }
}