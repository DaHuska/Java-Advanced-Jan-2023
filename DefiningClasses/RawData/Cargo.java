package com.company.DefiningClasses.RawData;

public class Cargo {
    private int cargoWeight;
    private String cargoType;

    Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
