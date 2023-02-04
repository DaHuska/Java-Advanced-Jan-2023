package com.company.DefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int engineInputTimes = Integer.parseInt(scan.nextLine());

        Map<String, Engine> engineCharacteristics = new HashMap<>();

        for (int i = 0; i < engineInputTimes; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = new Engine(model, power);

            String displacement;
            String efficiency;
            if (tokens.length > 2) {
                for (int g = 2; g <= tokens.length - 1; g++) {
                    String text = tokens[g];

                    if (Character.isDigit(text.charAt(0))) {
                        displacement = text;
                        engine.setDisplacement(displacement);
                    } else {
                        efficiency = text;
                        engine.setEfficiency(efficiency);
                    }
                }
            }

            engineCharacteristics.put(model, engine);
        }

        int carsInputTimes = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsInputTimes; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            String engineModel = tokens[1];

            Car car = new Car(model, engineCharacteristics.get(engineModel));

            String weight;
            String color;
            if (tokens.length > 2) {
                for (int g = 2; g <= tokens.length - 1; g++) {
                    String text = tokens[g];

                    if (Character.isDigit(text.charAt(0))) {
                        weight = text;
                        car.setWeight(weight);
                    } else {
                        color = text;
                        car.setColor(color);
                    }
                }
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.print(car);
        }
    }
}