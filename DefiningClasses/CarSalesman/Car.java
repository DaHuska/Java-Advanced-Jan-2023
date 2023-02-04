package com.company.DefiningClasses.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n",
                this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(),
                weight, color);
    }
}
