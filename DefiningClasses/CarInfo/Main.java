package com.company.DefiningClasses.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int carsCount = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < carsCount; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String brand = input[0];
            String model = input[1];
            int horsepower = Integer.parseInt(input[2]);

            Car car = new Car(brand, model, horsepower);

            System.out.println(car.toString());
        }
    }
}
