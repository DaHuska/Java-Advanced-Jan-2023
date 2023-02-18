package com.company.ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {

    public static final char TREE_SYMBOL = 'T';
    public static final char OUR_SYMBOL = 'Y';
    public static final char TREASURE_SYMBOL = 'X';

    public static final String UP_COMMAND = "up";
    public static final String DOWN_COMMAND = "down";
    public static final String LEFT_COMMAND = "left";
    public static final String RIGHT_COMMAND = "right";
    public static final String FINISH_COMMAND = "Finish";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] fieldDimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        char[][] field = new char[fieldDimensions[0]][fieldDimensions[1]];

        for (int i = 0; i < field.length; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String s = "";

            for (String s1 : input) {
                s += s1;
            }

            char[] arr = s.toCharArray();
            field[i] = arr;
        }

        int[] treasurePos = new int[2];
        int[] ourPos = new int[2];

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == OUR_SYMBOL) {
                    ourPos[0] = row;
                    ourPos[1] = col;
                }
                if (field[row][col] == 'X') {
                    treasurePos[0] = row;
                    treasurePos[1] = col;
                }
            }
        }

        List<String> path = new ArrayList<>();

        String command = scan.nextLine();
        while (!command.equals(FINISH_COMMAND)) {
            switch (command) {
                case UP_COMMAND:
                    int row = ourPos[0];
                    int col = ourPos[1];

                    try {
                        if (field[row - 1][col] != TREE_SYMBOL) {
                            field[row - 1][col] = OUR_SYMBOL;
                            field[row][col] = '-';

                            ourPos[0] = row - 1;

                            path.add(command);
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case DOWN_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (field[row + 1][col] != TREASURE_SYMBOL) {
                            field[row + 1][col] = OUR_SYMBOL;
                            field[row][col] = '-';

                            ourPos[0] = row + 1;

                            path.add(command);
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case LEFT_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (field[row][col - 1] != TREE_SYMBOL) {
                            field[row][col - 1] = OUR_SYMBOL;
                            field[row][col] = '-';

                            ourPos[1] = col - 1;

                            path.add(command);
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case RIGHT_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (field[row][col + 1] != TREE_SYMBOL) {
                            field[row][col + 1] = OUR_SYMBOL;
                            field[row][col] = '-';

                            ourPos[1] = col + 1;

                            path.add(command);
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
            }

            command = scan.nextLine();
        }

        if (ourPos[0] == treasurePos[0] && ourPos[1] == treasurePos[1]) {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }
}