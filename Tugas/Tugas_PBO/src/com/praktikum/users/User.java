package com.praktikum.users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getters
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    // Setters
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Abstract methods for GUI actions or logic (can be adapted)
    // The login logic might be handled differently in GUI (e.g., in LoginPane)
    // public abstract boolean login(String input1, String input2);

    // Display methods from CLI are replaced by GUI components
    // public abstract void displayAppMenu();
    // public void displayInfo() { ... };
}

