package com.company.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");

        Set<String> cars = new LinkedHashSet<>();

        while (!input[0].equals("END")) {
            String currCar = input[1];

            switch (input[0]) {
                case "IN":
                    cars.add(currCar);
                    break;
                case "OUT":
                    cars.remove(currCar);
                    break;
            }

            input = scan.nextLine().split(",\\s+");
        }
        
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(car -> System.out.println(car));
        }
    }
}
