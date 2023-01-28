package com.company.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> numbers = Arrays.asList(scan.nextLine().split(",\\s+"));

        Function<String, Integer> parseNums = number -> Integer.parseInt(number);
        Function<List<Integer>, Integer> sumNums = list -> list.stream().reduce(0, (a, b) -> Integer.sum(a, b));

        List<Integer> parsedNums = new ArrayList<>();

        numbers
                .forEach(number -> {
                    parsedNums.add(parseNums.apply(number));
                });

        System.out.printf("Count = %d%n", parsedNums.size());
        System.out.printf("Sum = %d", sumNums.apply(parsedNums));
    }
}
