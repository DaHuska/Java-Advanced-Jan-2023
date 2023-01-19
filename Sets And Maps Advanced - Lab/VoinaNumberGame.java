package com.company.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();

        firstDeck.addAll(firstInput);
        secondDeck.addAll(secondInput);

        int stepsCount = 0;

        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            if (stepsCount >= 50) {
                break;
            }

            int firstNumber = firstDeck.iterator().next();
            firstDeck.remove(firstNumber);

            int secondNumber = secondDeck.iterator().next();
            secondDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondDeck.add(firstNumber);
                secondDeck.add(secondNumber);
            }

            stepsCount++;
        }

        if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondDeck.size() < firstDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}