package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        Function<String, List<String>> messageToList = text -> Arrays.asList(text.split("\\s+"));
        Predicate<String> isUpper = word -> Character.isUpperCase(word.charAt(0));
        Consumer<List<String>> printList = list -> {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%s%n", list.get(i));
            }
        };

        List<String> words = messageToList.apply(message);

        words = words.stream().filter(word -> isUpper.test(word)).collect(Collectors.toList());

        System.out.printf("%d%n", words.size());
        printList.accept(words);
    }
}