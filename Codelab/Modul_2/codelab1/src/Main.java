class Hewan { //Class Hewan
    String Nama; // atribut dengan tipe data String
    String Jenis;
    String Suara;

    void tampilkanInfo() { //Method untuk print info hewan
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
    }
}

public class Main { //Main class
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan(); //objek Hewan 1
        Hewan hewan2 = new Hewan(); //Objek Hewan 2

        hewan1.Nama = "Kucing"; //Atribut hewan 1
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Nyann~~";

        hewan2.Nama = "Anjing"; //Atribut hewan 2
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Woof-Woof!!";

        hewan1.tampilkanInfo(); // Memanggil method tampilkanInfo() dari kedua objek
        System.out.println();
        hewan2.tampilkanInfo();
    }
}