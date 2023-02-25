package com.company.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    private static final String REMOVE_COMMAND = "Remove";
    private static final String DOUBLE_COMMAND = "Double";
    private static final String STARTS_WITH = "StartsWith";
    private static final String ENDS_WITH = "EndsWith";
    private static final String LENGTH = "Length";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if (input.equals("")) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        List<String> guests = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        input = scan.nextLine();

        while (!input.equals("Party!")) {
            String[] commands = input.split("\\s+");

            Predicate<String> isGuestValid = gePredicate(commands[1], commands[2]);

            switch (commands[0]) {
                case REMOVE_COMMAND:
                    for (int i = 0; i < guests.size(); i++) {
                        if (isGuestValid.test(guests.get(i))) {
                            guests.remove(i);

                            if (i > 0) {
                                i--;
                            }
                        }
                    }
                    break;
                case DOUBLE_COMMAND:
                    int listSize = guests.size();

                    for (int i = 0; i < listSize; i++) {
                        if (isGuestValid.test(guests.get(i))) {
                            guests.add(guests.get(i));
                        }
                    }
                    break;
            }

            input = scan.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests = guests
                        .stream()
                        .sorted((g1, g2) -> g1.compareTo(g2))
                        .collect(Collectors.toList());

            System.out.printf("%s are going to the party!", String.join(", ", guests));
        }

        // 80/100
    }

    public static Predicate<String> gePredicate(String command, String validator) {
        switch (command) {
            case STARTS_WITH:
                return guest -> guest.startsWith(validator);
            case ENDS_WITH:
                return guest -> guest.endsWith(validator);
            case LENGTH:
                return guest -> guest.length() == Integer.parseInt(validator);
        }
        throw new RuntimeException("Wrong input command!");
    }
}
