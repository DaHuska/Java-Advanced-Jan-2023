package com.company.SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(":\\s+");

        Map<String, Set<String>> nameCards = new LinkedHashMap<>();

        while (!input[0].equals("JOKER")) {
            String name = input[0];
            String[] cardsSequence = input[1].split(",\\s+");

            nameCards.putIfAbsent(name, new HashSet<>());

            for (int i = 0; i < cardsSequence.length; i++) {
                nameCards.get(name).add(cardsSequence[i]);
            }

            input = scan.nextLine().split(":\\s+");
        }

        nameCards
                .forEach((person, cards) -> {
                    int totalValue = 0;

                    int power = 0;
                    int multiplier = 0;

                    Iterator<String> iterator = cards.iterator();

                    while (iterator.hasNext()) {
                        String currCard = iterator.next();

                        if (currCard.length() > 2) {
                            power = Integer.parseInt(currCard.substring(0, 2));

                            if (currCard.charAt(2) == 'S') {
                                multiplier = 4;
                            } else if (currCard.charAt(2) == 'H') {
                                multiplier = 3;
                            } else if (currCard.charAt(2) == 'D') {
                                multiplier = 2;
                            } else if (currCard.charAt(2) == 'C') {
                                multiplier = 1;
                            }
                        } else {
                            if (currCard.charAt(0) == 'J') {
                                power = 11;
                            } else if (currCard.charAt(0) == 'Q') {
                                power = 12;
                            } else if (currCard.charAt(0) == 'K') {
                                power = 13;
                            } else if (currCard.charAt(0) == 'A') {
                                power = 14;
                            } else {
                                power = Integer.parseInt(String.valueOf(currCard.charAt(0)));
                            }

                            if (currCard.charAt(1) == 'S') {
                                multiplier = 4;
                            } else if (currCard.charAt(1) == 'H') {
                                multiplier = 3;
                            } else if (currCard.charAt(1) == 'D') {
                                multiplier = 2;
                            } else if (currCard.charAt(1) == 'C') {
                                multiplier = 1;
                            }
                        }

                        totalValue += power * multiplier;
                    }

                    System.out.printf("%s: %d%n", person, totalValue);
                });
    }
}
