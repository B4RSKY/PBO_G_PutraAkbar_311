import java.util.Scanner;

//Class Admin
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

//Class Mahasiswa
class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public boolean login(String inputNama, String inputNim) {
        return nama.equals(inputNama) && nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

//Class Utama
public class PBO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek Admin dan Mahasiswa
        Admin admin = new Admin("admin311", "password311");
        Mahasiswa mahasiswa = new Mahasiswa("Mohammad Putra Akbar Rafsanjani", "202410370110311");

        System.out.print("Pilih Login:\n1. Admin\n2. Mahasiswa\n");

        System.out.print("Masukkan Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username: ");
                String username = input.nextLine();
                System.out.print("Masukkan Password: ");
                String password = input.nextLine();

                if (admin.login(username, password)) {
                    System.out.print("Login Admin Berhasil!\n");
                } else {
                    System.out.print("Login gagal! username atau password salah\n");
                }
                break;
            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = input.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    System.out.print("Login Mahasiswa Berhasil!\n");
                    mahasiswa.displayInfo();
                } else {
                    System.out.print("Login gagal! nama atau nim salah\n");
                }
                break;
            default:
                System.out.print("Pilihan Tidak Valid\n");
                main(args);
        }
    }
}