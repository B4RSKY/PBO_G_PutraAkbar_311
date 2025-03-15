import java.util.Scanner;

// Class RekeningBank
class RekeningBank {
    // Atribut
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // Metode untuk menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }

    // Metode untuk menyetor uang
    void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ".\n Saldo sekarang: Rp" + saldo);
    }

    // Metode untuk menarik uang
    void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil)\n Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi)\n Saldo saat ini: Rp" + saldo);
        }
    }
}

// Class Main
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek rekening1
        RekeningBank rekening1 = new RekeningBank();
        rekening1.nomorRekening = "202410370110311";
        rekening1.namaPemilik = "Akbar GG";
        rekening1.saldo = 500000.0;

        // Membuat objek rekening2
        RekeningBank rekening2 = new RekeningBank();
        rekening2.nomorRekening = "202410370110310";
        rekening2.namaPemilik = "Barry Allen";
        rekening2.saldo = 1000000.0;

        int pilihan = 0;
        RekeningBank rekeningAktif = null; // Menyimpan referensi ke rekening yang sedang aktif, null berarti belum ada rekening yang dipilih

        // Memulai loop yang akan terus berjalan sampai pengguna memilih untuk keluar (pilihan == 5)
        do {
            System.out.println("\n===== MENU TRANSAKSI BANK BERGANTUNG =====");
            System.out.println("1. Lihat Rekening 1");
            System.out.println("2. Lihat Rekening 2");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            // switch untuk menangani pilihan menu yang berbeda
            switch (pilihan) {
                case 1:
                    System.out.println("\n--- INFO REKENING 1 ---");
                    rekening1.tampilkanInfo();
                    rekeningAktif = rekening1; // Menetapkan rekening1 sebagai rekening aktif untuk transaksi berikutnya
                    break;
                case 2:
                    System.out.println("\n--- INFO REKENING 2 ---");
                    rekening2.tampilkanInfo();
                    rekeningAktif = rekening2; // Menetapkan rekening2 sebagai rekening aktif untuk transaksi berikutnya
                    break;
                case 3:
                    // Memeriksa apakah rekening aktif sudah dipilih sebelumnya
                    if (rekeningAktif == null) {
                        System.out.println("\nPilih rekening terlebih dahulu (Menu 1 atau 2)!");
                    } else {
                        System.out.println("\n--- SETOR TUNAI ---");
                        System.out.println("Rekening aktif: " + rekeningAktif.namaPemilik);
                        System.out.print("Masukkan jumlah setoran: Rp");
                        // Menyimpan nilai input jumlah setoran
                        double jumlahSetor = input.nextDouble();
                        if (jumlahSetor <= 0) {
                            System.out.println("Jumlah setoran harus lebih dari 0!");
                        } else {
                            // Memanggil metode setorUang dengan jumlah yang dimasukkan
                            rekeningAktif.setorUang(jumlahSetor);
                        }
                    }
                    break;
                case 4:
                    if (rekeningAktif == null) {
                        System.out.println("\nPilih rekening terlebih dahulu (Menu 1 atau 2)!");
                    } else {
                        System.out.println("\n--- TARIK TUNAI ---");
                        System.out.println("Rekening aktif: " + rekeningAktif.namaPemilik);
                        System.out.print("Masukkan jumlah penarikan: Rp");
                        double jumlahTarik = input.nextDouble();
                        if (jumlahTarik <= 0) {
                            System.out.println("Jumlah penarikan harus lebih dari 0!");
                        } else {
                            rekeningAktif.tarikUang(jumlahTarik);
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nTerima kasih telah menggunakan layanan bank kami!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan pilih menu 1-5.");
            }
        } while (pilihan != 5);

        input.close();
    }
}