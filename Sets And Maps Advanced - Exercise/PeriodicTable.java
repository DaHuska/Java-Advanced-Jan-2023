package com.company.SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputTimes = Integer.parseInt(scan.nextLine());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < inputTimes; i++) {
            String[] compoundsInput = scan.nextLine().split("\\s+");

            compounds.addAll(Arrays.asList(compoundsInput));
        }

        compounds
                .forEach(element -> System.out.print(element + " "));
    }
}
