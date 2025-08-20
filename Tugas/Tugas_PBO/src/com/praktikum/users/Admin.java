package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import java.util.List;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Login logic is handled by DataStore.loginAdmin

    // AdminActions implementations (logic moved from CLI methods)
    @Override
    public void manageItems() {
        // This method's logic will be implemented within the AdminDashboard GUI
        // For now, it might just provide data access or trigger GUI updates
        System.out.println("Admin is managing items (GUI implementation needed).");
    }

    @Override
    public void manageUsers() {
        // This method's logic will be implemented within the AdminDashboard GUI
        System.out.println("Admin is managing users (GUI implementation needed).");
    }

    // Methods previously in CLI Admin class, now potentially moved to DataStore or GUI controllers
    public List<Item> viewAllItems() {
        return DataStore.getAllItems();
    }

    public boolean markItemAsClaimed(Item item) {
         if (item != null && "Reported".equalsIgnoreCase(item.getStatus())) {
            item.setStatus("Claimed");
            // In a real app, you might need to update the data source persistently
            return true;
        }
        return false;
    }

     public boolean markItemAsClaimedByIndex(int index) {
        Item item = DataStore.findItemByIndex(index);
        return markItemAsClaimed(item);
    }

    public List<Mahasiswa> viewAllUsers() {
        return DataStore.getAllMahasiswa();
    }

    public boolean addMahasiswa(String nama, String nim) {
        // Check if NIM already exists
        if (DataStore.getUserList().stream().anyMatch(user -> user.getNim().equals(nim))) {
            return false; // NIM exists
        }
        Mahasiswa newUser = new Mahasiswa(nama, nim);
        DataStore.addMahasiswa(newUser);
        return true;
    }

    public boolean deleteMahasiswa(String nim) {
        return DataStore.deleteMahasiswa(nim);
    }
}

