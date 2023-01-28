package com.company.FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {

    public static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if (condition.equals("younger")) {
            return age -> age <= ageLimit;
        } else if (condition.equals("older")) {
            return age -> age >= ageLimit;
        }

        throw new RuntimeException("Wrong input 2");
    }

    public static Consumer<Map.Entry<String, Integer>> getConsumer(String format) {
        if (format.equals("name")) {
            return entry -> System.out.printf("%s%n", entry.getKey());
        } else if (format.equals("age")) {
            return entry -> System.out.printf("%d%n", entry.getValue());
        } else if (format.equals("name age")) {
            return entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }

        throw new RuntimeException("Wrong input 1");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> nameAge = new LinkedHashMap<>();
        Function<String, Integer> parseAge = age -> Integer.parseInt(age);

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(",\\s+");

            String name = input[0];
            int age = parseAge.apply(input[1]);

            nameAge.putIfAbsent(name, 0);
            nameAge.put(name, age);
        }

        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> filterAge = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> printEntry = getConsumer(format);

        nameAge.entrySet()
               .stream()
               .filter(entry -> filterAge.test(entry.getValue()))
                .forEach(entry -> printEntry.accept(entry));
        
    }
}
