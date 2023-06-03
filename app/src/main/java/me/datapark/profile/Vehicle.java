package me.datapark.profile;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private final String plate;
    private final String brand;
    private final String model;
    private final String fueltype;
    private final String power;
    private final String notes;

    public Vehicle(String plate, String brand, String model, String fueltype, String power, String notes) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.fueltype = fueltype;
        this.power = power;
        this.notes = notes;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuelType() {
        return fueltype;
    }

    public String getPower() {
        return power;
    }

    public String getNotes() {
        return notes;
    }
}
