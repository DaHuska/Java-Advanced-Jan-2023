package com.company.DefiningClasses.RawData;

public class Tire {
    private double tirePressure;
    private int tireAge;

    Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return this.tirePressure;
    }
}
