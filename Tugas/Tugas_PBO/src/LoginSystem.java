import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Admin admin = new Admin("Administrator", "ADMIN123", "admin311", "password311");
        Mahasiswa mahasiswa = new Mahasiswa("Mohammad Putra Akbar Rafsanjani", "202410370110311");
        
        System.out.println("=== SISTEM LOGIN ===");
        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        
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
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal! Username atau password salah");
                }
                break;
                
            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = input.nextLine();
                
                if (mahasiswa.login(nama, nim)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah");
                }
                break;
                
            default:
                System.out.println("Pilihan Tidak Valid");
                main(args);
        }
        
        input.close();
    }
}