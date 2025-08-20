package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.DataStore;
import com.praktikum.data.Item;
import java.util.List;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Login logic is handled by DataStore.loginMahasiswa

    // MahasiswaActions implementations (logic moved from CLI methods)
    @Override
    public void reportItem() {
        // This method's logic will be implemented within the MahasiswaDashboard GUI
        // It might involve taking data from GUI fields and calling DataStore.addItem
        System.out.println("Mahasiswa is reporting an item (GUI implementation needed).");
    }

    @Override
    public void viewReportedItems() {
        // This method's logic will be implemented within the MahasiswaDashboard GUI
        // It might involve fetching data using DataStore.getReportedStatusItems and displaying it
        System.out.println("Mahasiswa is viewing reported items (GUI implementation needed).");
    }

    // Method to report an item (called from GUI)
    public boolean submitReport(String itemName, String description, String location) {
        if (itemName == null || itemName.trim().isEmpty() ||
            description == null || description.trim().isEmpty() ||
            location == null || location.trim().isEmpty()) {
            return false; // Basic validation
        }
        Item newItem = new Item(itemName, description, location, getNim());
        DataStore.addItem(newItem);
        return true;
    }

    // Method to get items with 'Reported' status (for GUI display)
    public List<Item> getReportedStatusItemsList() {
        return DataStore.getReportedStatusItems();
    }
}

