package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVAT = price -> price * 1.2;
        Consumer<Double> printPrice = price -> System.out.printf("%.2f%n", price);

        System.out.println("Prices with VAT:");
        prices
                .stream()
                .mapToDouble(price -> addVAT.apply(price))
                .forEach(priceWithVat -> printPrice.accept(priceWithVat));
    }
}
