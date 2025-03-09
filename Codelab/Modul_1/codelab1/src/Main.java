import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Membuat Scanner untuk input user
        Scanner input = new Scanner(System.in);

        // user input memasukkan nama
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        // user input gender
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char inputGender = input.next().charAt(0);

        // user input taun lahir
        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = input.nextInt();

        // Menutup scanner
        input.close();

        // Menghitung umur
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin
        String jenisKelamin;
        if (inputGender == 'L' || inputGender == 'l') {
            jenisKelamin = "Laki-laki";
        } else if (inputGender == 'P' || inputGender == 'p') {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Tidak diketahui";
        }

        // Menampilkan output
        System.out.println("\nData Diri:");
        System.out.println("Nama           : " + nama);
        System.out.println("Jenis Kelamin  : " + jenisKelamin);
        System.out.println("Umur           : " + umur + " tahun");
    }
}