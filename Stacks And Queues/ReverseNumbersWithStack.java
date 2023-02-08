package com.company.Stacks_And_Queues;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(input);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < input.size(); i++) {
            numbers.offer(input.get(i));
        }

        while (numbers.size() > 0) {
            System.out.print(numbers.poll() + " ");
        }
    }
}
