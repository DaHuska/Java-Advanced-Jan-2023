package com.company.SetsAndMaps;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");

        Map<String, Map<String, Long>> countryCityPop = new LinkedHashMap<>();
        Map<String, Long> countryPopulationCount = new LinkedHashMap<>();

        while (!input[0].equals("report")) {
            String city = input[0];
            String country = input[1];
            long population = Integer.parseInt(input[2]);

            countryCityPop.putIfAbsent(country, new LinkedHashMap<>());
            countryCityPop.get(country).putIfAbsent(city, 0L);
            countryCityPop.get(country).put(city, population);

            countryPopulationCount.putIfAbsent(country, 0L);

            input = scan.nextLine().split("\\|");
        }

        countryCityPop
                .entrySet()
                .forEach(country -> {
                        long currPopulation = country.getValue()
                                .entrySet()
                                .stream()
                                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                                .mapToLong(Map.Entry::getValue)
                                .sum();

                        countryPopulationCount.put(country.getKey(), currPopulation);
                });

        countryCityPop.entrySet().stream()
                .sorted((c1,c2)-> countryPopulationCount.get(c2.getKey()).compareTo(countryPopulationCount.get(c1.getKey())))
                .forEach(country ->{
                    System.out.format("%s (total population: %d)%n",country.getKey(),countryPopulationCount.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                        System.out.format("=>%s: %d%n", city.getKey(),city.getValue());
                    });
                });
    }
}
