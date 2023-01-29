package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> names = Arrays.asList(scan.nextLine().split("\\s+"));

        Consumer<String> printNames = name -> System.out.println(name);

        names.forEach(name -> printNames.accept(name));
    }
}
