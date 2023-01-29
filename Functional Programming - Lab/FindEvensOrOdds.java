package com.company.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static Predicate<Integer> checkNumber(String command) {
        switch (command) {
            case "even":
                return number -> number % 2 == 0;
            case "odd":
                return number -> number % 2 != 0;
        }
        throw new RuntimeException("Wrong input");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numberBorders = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> numbers = new ArrayList<>();

        for (int i = numberBorders[0]; i <= numberBorders[1]; i++) {
            numbers.add(i);
        }

        String command = scan.nextLine();

        Predicate<Integer> isValidNumber = checkNumber(command);
        Consumer<Integer> printNumbers = number -> System.out.print(number + " ");

        numbers
                .stream()
                .filter(number -> isValidNumber.test(number))
                .forEach(number -> printNumbers.accept(number));
    }
}
