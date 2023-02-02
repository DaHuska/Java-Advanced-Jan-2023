package com.company.FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {

    public static UnaryOperator<Integer> getModifiedNum(String command) {
        switch (command) {
            case "add":
                return num -> num += 1;
            case "multiply":
                return num -> num *= 2;
            case "subtract":
                return num -> num -= 1;
        }
        throw new RuntimeException("Error!");
    }

    public static Consumer<Integer> getConsumer() {
        return num -> System.out.print(num + " ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();
        Consumer<Integer> printNums = getConsumer();
        List<Integer> modifiedNumbers = new ArrayList<>();

        while (!command.equals("end")) {

            if (command.equals("print")) {
                modifiedNumbers
                        .forEach(num -> printNums.accept(num));
                System.out.println();
            } else if (command.equals("add") || command.equals("multiply") || command.equals("subtract")){
                UnaryOperator<Integer> modifyNumber = getModifiedNum(command);

                modifiedNumbers = numbers
                        .stream()
                        .map(num -> modifyNumber.apply(num))
                        .collect(Collectors.toList());

                numbers = modifiedNumbers;
            }

            command = scan.nextLine();
        }
    }
}
