package com.company.DefiningClasses.RawData;

import java.util.*;
import java.util.function.Consumer;

public class Main {

    private static final String FRAGILE_COMMAND = "fragile";
    private static final String FLAMABLE_COMMAND = "flamable";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputTimes = Integer.parseInt(scan.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < inputTimes; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            List<Tire> tires = new ArrayList<>();

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            for (int g = 0; g < 8; g += 2) {
                double tirePressure = Double.parseDouble(tokens[5 + g]);
                int tireAge = Integer.parseInt(tokens[6 + g]);

                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, engine, cargo, tires);

            carsMap.put(model, car);
        }

        String command = scan.nextLine();

        Consumer<Car> printCar = car -> System.out.println(car.getModel());

        switch (command) {
            case FRAGILE_COMMAND:
                carsMap
                        .entrySet()
                        .stream()
                        .filter(car -> car.getValue().getCargo().getCargoType().equals(FRAGILE_COMMAND)
                        && areTiresValid(car.getValue().getTires()))
                        .forEach(car -> printCar.accept(car.getValue()));
                break;
            case FLAMABLE_COMMAND:
                carsMap
                        .entrySet()
                        .stream()
                        .filter(car -> car.getValue().getCargo().getCargoType().equals(FLAMABLE_COMMAND)
                        && car.getValue().getEngine().getEnginePower() > 250)
                        .forEach(car -> printCar.accept(car.getValue()));
                break;
        }
    }

    public static boolean areTiresValid(List<Tire> tires) {
        for (Tire tire : tires) {
            if (tire.getTirePressure() < 1) {
                return true;
            }
        }

        return false;
    }
}