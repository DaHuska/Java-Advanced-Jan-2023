package com.company.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberRange = Integer.parseInt(scan.nextLine());
        List<Integer> inputSequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> foundNumbers = new ArrayList<>();

        BiPredicate<Integer, Integer> validateNumber = (number1, number2) -> number1 % number2 == 0;
        Consumer<List<Integer>> printFoundNumbers = list -> list.forEach(number -> System.out.print(number + " "));

        for (int i = 1; i <= numberRange; i++) {
            boolean isValid = false;

            for (int g = 0; g < inputSequence.size(); g++) {
                if (validateNumber.test(i, inputSequence.get(g))) {
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                foundNumbers.add(i);
            }
        }

        printFoundNumbers.accept(foundNumbers);
    }
}
