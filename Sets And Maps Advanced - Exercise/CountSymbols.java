package com.company.SetsAndMaps;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> symbolOccurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currSymbol = input.charAt(i);

            symbolOccurrences.putIfAbsent(currSymbol, 0);
            symbolOccurrences.put(currSymbol, symbolOccurrences.get(currSymbol) + 1);
        }

        symbolOccurrences
                .forEach((symbol, occurrence) -> {
                    System.out.printf("%c: %d time/s%n", symbol, occurrence);
                });
    }
}
