package com.company.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> inputNumbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> numberOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < inputNumbers.size(); i++) {
            double currNumber = inputNumbers.get(i);

            numberOccurrences.putIfAbsent(currNumber, 0);
            numberOccurrences.put(currNumber, numberOccurrences.get(currNumber) + 1);
        }

        numberOccurrences
                .forEach((number, occurrence) -> {
                    System.out.printf("%.1f -> %d%n", number, occurrence);
                });
    }
}
