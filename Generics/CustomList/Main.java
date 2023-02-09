package com.company.Generics.CustomList;

import java.util.Scanner;

public class Main {

    private static final String ADD_COMMAND = "Add";
    private static final String REMOVE_COMMAND = "Remove";
    private static final String CONTAINS_COMMAND = "Contains";
    private static final String SWAP_COMMAND = "Swap";
    private static final String GREATER_COMMAND = "Greater";
    private static final String MAX_COMMAND = "Max";
    private static final String MIN_COMMAND = "Min";
    private static final String PRINT_COMMAND = "Print";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Custom<String> customList = new Custom<>();

        while (!input.equals(END_COMMAND)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case ADD_COMMAND:
                    String data = tokens[1];

                    customList.add(data);
                    break;
                case REMOVE_COMMAND:
                    int index = Integer.parseInt(tokens[1]);

                    customList.remove(index);
                    break;
                case CONTAINS_COMMAND:
                    data = tokens[1];

                    System.out.println(customList.contains(data));
                    break;
                case SWAP_COMMAND:
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    customList.swap(firstIndex, secondIndex);
                    break;
                case GREATER_COMMAND:
                    data = tokens[1];

                    int counter = 0;
                    for (int i = 0; i < customList.getList().size(); i++) {
                        customList.setElementIndex(i);

                        int result = customList.getList().get(i).compareTo(data);
                        if (result > 0) {
                            counter++;
                        }
                    }
                    System.out.println(counter);
                    break;
                case MAX_COMMAND:

                    System.out.println(customList.getMax());

                    break;
                case MIN_COMMAND:

                    System.out.println(customList.getMin());

                    break;
                case PRINT_COMMAND:

                    customList.printList();

                    break;
            }

            input = scan.nextLine();
        }

        // not tested in Judge - Judge maintenance period
    }
}