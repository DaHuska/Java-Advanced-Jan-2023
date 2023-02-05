package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestNumIndex = list -> {
            int smallestNum = Integer.MAX_VALUE;
            int smallestIndex = -1;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= smallestNum) {
                    smallestNum = list.get(i);
                    smallestIndex = i;
                }
            }

            return smallestIndex;
        };

        System.out.println(getSmallestNumIndex.apply(numbers));
    }
}
