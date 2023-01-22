package com.company.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("@");

        Map<String, Map<String, Integer>> venueSinger = new LinkedHashMap<>();

        while (!input[0].equals("End")) {
            String singer = input[0];
            StringBuilder venue = new StringBuilder();

            String[] tokens = input[1].split(" ");

            if (tokens.length > 2 && tokens.length <= 5 && singer.endsWith(" ")) {
                for (int i = 0; i < tokens.length - 2; i++) {
                    if (i == tokens.length - 3) {
                        venue.append(tokens[i]);
                    } else {
                        venue.append(tokens[i]).append(" ");
                    }
                }
                singer = singer.substring(0, singer.length() - 1);

                try {
                    int ticketPrice = Integer.parseInt(tokens[tokens.length - 2]);
                    int ticketCount = Integer.parseInt(tokens[tokens.length - 1]);

                    int totalPrice = ticketPrice * ticketCount;

                    String venueString = String.valueOf(venue);

                    venueSinger.putIfAbsent(venueString, new LinkedHashMap<>());
                    venueSinger.get(venueString).putIfAbsent(singer, 0);
                    venueSinger.get(venueString).put(singer, venueSinger.get(venueString).get(singer) + totalPrice);
                } catch (Exception ignored) {}
            }

            input = scan.nextLine().split("@");
        }

        venueSinger
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());

                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(value -> System.out.printf("#  %s -> %d%n", value.getKey(), value.getValue()));
                });
    }
}
