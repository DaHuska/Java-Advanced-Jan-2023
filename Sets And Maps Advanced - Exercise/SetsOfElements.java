package com.company.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static Set<Integer> fillSet(Set<Integer> set, int size, Scanner scanner) {

        for (int i = 0; i < size; i++) {
            int currNumber = Integer.parseInt(scanner.nextLine());

            set.add(currNumber);
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int firstSize = Integer.parseInt(input[0]);
        int secondSize = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        firstSet = fillSet(firstSet, firstSize, scan);
        secondSet = fillSet(secondSet, secondSize, scan);

        firstSet.retainAll(secondSet);
        firstSet
                .forEach(number -> System.out.print(number + " "));
    }
}
