package com.company.SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputTimes = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continentCountry = new LinkedHashMap<>();

        for (int i = 0; i < inputTimes; i++) {
            String[] inputTokens = scan.nextLine().split("\\s+");

            String continent = inputTokens[0];
            String country = inputTokens[1];
            String town = inputTokens[2];

            continentCountry.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountry.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountry.get(continent).get(country).add(town);
        }

        continentCountry
                .forEach((continent, country) -> {
                    System.out.printf("%s:%n", continent);

                    country
                            .forEach((key, town) -> {
                                System.out.printf("  %s -> ", key);

                                for (int i = 0; i < town.size(); i++) {
                                    if (i == town.size() - 1) {
                                        System.out.printf("%s", town.get(i));
                                    } else {
                                        System.out.printf("%s, ", town.get(i));
                                    }
                                }
                                System.out.println();
                            });
                });
    }
}
