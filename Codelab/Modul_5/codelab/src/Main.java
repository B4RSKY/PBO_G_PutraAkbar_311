import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class StokTidakCukupException extends Exception {
    public StokTidakCukupException(String message) {
        super(message);
    }
}

class Barang {
    private String nama;
    private int stok;

    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
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

    public String toString() {
        return nama + " (Jumlah: " + stok + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        daftarBarang.add(new Barang("Pensil", 50));
        daftarBarang.add(new Barang("Penghapus", 20));
        daftarBarang.add(new Barang("Hp", 2));

        System.out.println("Daftar barang sebelum dihapus:");
        for (Barang barang : daftarBarang) {
            System.out.println(barang);
        }

        daftarBarang.remove(1);

        System.out.println("\nDaftar barang setelah dihapus:");
        for (Barang barang : daftarBarang) {
            System.out.println(barang);
        }

        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();

                        int stok = 0;
                        try {
                            System.out.print("Masukkan stok awal: ");
                            stok = scanner.nextInt();
                            scanner.nextLine();

                            if (stok < 0) {
                                System.out.println("Stok tidak boleh negatif!");
                                continue;
                            }

                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang " + nama + " ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka!");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                        } else {
                            System.out.println("--- Daftar Barang ---");
                            for (int i = 0; i < daftarBarang.size(); i++) {
                                Barang b = daftarBarang.get(i);
                                System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                            }
                            System.out.println("--------------------");
                        }
                        break;

                    case 3:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                            break;
                        }

                        System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }

                        try {
                            System.out.print("Masukkan nomor indeks barang: ");
                            int indeks = scanner.nextInt();
                            scanner.nextLine();

                            if (indeks < 0 || indeks >= daftarBarang.size()) {
                                throw new IndexOutOfBoundsException("Indeks tidak valid!");
                            }

                            Barang barang = daftarBarang.get(indeks);

                            System.out.print("Masukkan jumlah stok yang akan diambil: ");
                            int jumlahDiambil = scanner.nextInt();
                            scanner.nextLine();

                            if (jumlahDiambil < 0) {
                                System.out.println("Jumlah yang diambil tidak boleh negatif!");
                                continue;
                            }

                            if (jumlahDiambil > barang.getStok()) {
                                throw new StokTidakCukupException("Stok untuk " + barang.getNama() +
                                        " hanya tersisa " + barang.getStok());
                            }

                            barang.setStok(barang.getStok() - jumlahDiambil);
                            System.out.println("Stok barang \"" + barang.getNama() + "\" berhasil dikurangi. Sisa stok: " + barang.getStok());

                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (StokTidakCukupException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Program berakhir.");
                        break;

                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih 0-3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        }

        scanner.close();
    }
}