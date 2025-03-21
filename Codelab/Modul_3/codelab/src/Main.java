// Kelas Karakter Game
class KarakterGame {
    private String nama;
    private int kesehatan;

    //Constructor
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    //Getter dan setter
    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public int getHealth() {
        return kesehatan;
    }

    public void setHealth(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    //Method seranng (untuk override subclass)
    public void serang(KarakterGame target) {
        // Default implementation
    }
}

//Class pahlawan (subclass karaktergame)
class Pahlawan extends KarakterGame {
    //Constructor
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    //Override method serang
    public void serang(KarakterGame target) {
        System.out.println(getName() + " Menyerang " + target.getName() + " menggunakan pedang!");
        target.setHealth(target.getHealth() - 20);
        System.out.println(target.getName() + " Sekarang Memiliki Kesehatan " + target.getHealth());
    }
}

//Class Musuh (subclass karaktergame)
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    public void serang(KarakterGame target) {
        System.out.println(getName() + " Menyerang " + target.getName() + " menggunakan sihir");
        target.setHealth(target.getHealth() -  15);
        System.out.println(target.getName() + " Sekarang Memiliki Kesehatan " + target.getHealth());
    }
}

//Class utama (Main)
public class Main {
    public static void main(String[] args) {
        // Membuat objek
        KarakterGame umum = new KarakterGame("Karakter umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("Status awal: ");
        System.out.println(brimstone.getName() + " Memiliki kesehatan " + brimstone .getHealth());
        System.out.println(viper.getName() + " Memiliki kesehatan " + viper .getHealth());

        System.out.println("\nPertarungan dimulai!");
        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
