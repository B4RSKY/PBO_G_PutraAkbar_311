package com.praktikum.data;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status;
    private String reporterNim; // NIM pelapor untuk identifikasi

    public Item(String itemName, String description, String location, String reporterNim) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = "Reported"; // Default status
        this.reporterNim = reporterNim;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getReporterNim() {
        return reporterNim;
    }

    // Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReporterNim(String reporterNim) {
        this.reporterNim = reporterNim;
    }

    // toString for display purposes (optional, but can be useful)
    @Override
    public String toString() {
        return "Item{" + "itemName='" + itemName + '\'' + ", description='" + description + '\'' + ", location='" + location + '\'' + ", status='" + status + '\'' + ", reporterNim='" + reporterNim + '\'' + '}';
    }
}

