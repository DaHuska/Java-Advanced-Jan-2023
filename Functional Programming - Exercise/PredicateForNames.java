package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int passedNumber = Integer.parseInt(scan.nextLine());

        List<String> names = Arrays.asList(scan.nextLine().split("\\s+"));

        Predicate<String> isNameValid = name -> name.length() <= passedNumber;

        names
                .stream()
                .filter(isNameValid)
                .forEach(name -> System.out.println(name));
    }
}
