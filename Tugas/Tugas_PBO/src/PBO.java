import java.util.Scanner;

public class PBO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Pilih Login:\n1. Admin\n2. Mahasiswa\n");

        System.out.print("Masukkan Pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                admin(args);
                break;
            case 2:
                mhs(args);
                break;
            default:
                System.out.print("Pilihan Tidak Valid\n");
                main(args);
        }
    }
    public static void admin (String[] args) {
        Scanner input = new Scanner(System.in);

        String usbener = "admin311";
        String pwbener = "password311";

        System.out.print("Masukkan Username: ");
        String username = input.nextLine();
        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        if(username.equals(usbener) && password.equals(pwbener)){
            System.out.print("Login Admin Berhasil!");
        } else {
            System.out.print("Login gagal! username atau password salah\n");
            main(args);
        }

        //System.out.println("USERNAME: " + username);
        //System.out.println("PASSWORD: " + password);
    }
    public static void mhs (String[] args){
        Scanner input = new Scanner(System.in);

        String namabener = "Mohammad Putra Akbar Rafsanjani";
        String nimbener = "202410370110311";

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        if(nama.equals(namabener) && nim.equals(nimbener)){
            System.out.print("Login Admin Berhasil!\n");
            System.out.println("Nama: " + nama);
            System.out.println("NIM: " + nim);
        } else {
            System.out.print("Login gagal! nama atau nim salah\n");
            main(args);
        }
    }
}