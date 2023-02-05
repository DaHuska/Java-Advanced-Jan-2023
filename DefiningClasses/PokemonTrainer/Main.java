package com.company.DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {

    private static final String FIRE_ELEMENT = "Fire";
    private static final String WATER_ELEMENT = "Water";
    private static final String ELECTRICITY_ELEMENT = "Electricity";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Map<String, List<Pokemon>> trainerPokemons = new LinkedHashMap<>();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        Map<String, Integer> trainerBadges = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, trainerPokemons.get(trainerName));

            trainerPokemons.putIfAbsent(trainer.getName(), new ArrayList<>());
            trainerPokemons.get(trainer.getName()).add(pokemon);

            trainerMap.put(trainerName, trainer);

            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("End")) {
            String element = command;

            if (element.equals(FIRE_ELEMENT) || element.equals(WATER_ELEMENT) || element.equals(ELECTRICITY_ELEMENT)) {
                trainerPokemons
                        .entrySet()
                        .stream()
                        .forEach(entry -> {
                            boolean isExistent = false;

                            for (Pokemon pokemon : entry.getValue()) {
                                if (pokemon.getElement().equals(element)) {
                                    trainerMap.get(entry.getKey()).setBadges();
                                    isExistent = true;
                                    break;
                                }
                            }

                            if (!isExistent) {
                                for (int i = 0; i < entry.getValue().size(); i++) {
                                    entry.getValue().get(i).reduceHealth(10);

                                    trainerPokemons
                                            .entrySet()
                                            .stream()
                                            .forEach(entry2 -> {
                                                List<Pokemon> list = entry2.getValue();

                                                for (int g = 0; g < list.size(); g++) {
                                                    if (list.get(g).getHealth() <= 0) {
                                                        list.remove(g);
                                                        g--;
                                                    }
                                                }
                                            });
                                }
                            }
                        });
            }

            command = scan.nextLine();
        }

        trainerMap
                .entrySet()
                .stream()
                .forEach(trainer -> {
                    trainerBadges.putIfAbsent(trainer.getKey(), 0);
                    trainerBadges.put(trainer.getKey(), trainer.getValue().getBadges());
                });

        trainerPokemons
                .entrySet()
                .stream()
                .sorted((t1, t2) -> trainerBadges.get(t2.getKey()).compareTo(trainerBadges.get(t1.getKey())))
                .forEach(entry -> System.out.printf("%s %d %d%n", entry.getKey(), trainerBadges.get(entry.getKey()), entry.getValue().size()));
    }
}