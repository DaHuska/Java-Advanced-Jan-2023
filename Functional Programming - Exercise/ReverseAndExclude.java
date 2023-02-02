package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static Predicate<Integer> getPredicate(int divisibleNum) {
        return num -> num % divisibleNum == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int divisibleNum = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> isValid = getPredicate(divisibleNum);

        numbers
                .removeIf(num -> isValid.test(num));

        numbers.forEach(num -> System.out.print(num + " "));
    }
}