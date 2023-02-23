package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlindManBuff {

    public static final char OBSTACLE_SYMBOL = 'O';
    public static final char OUR_SYMBOL = 'B';
    public static final char OPPONENTS_SYMBOL = 'P';

    public static final String UP_COMMAND = "up";
    public static final String DOWN_COMMAND = "down";
    public static final String LEFT_COMMAND = "left";
    public static final String RIGHT_COMMAND = "right";
    public static final String FINISH_COMMAND = "Finish";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] playgroundDimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        char[][] playground = new char[playgroundDimensions[0]][playgroundDimensions[1]];

        for (int i = 0; i < playground.length; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String s = "";

            for (String s1 : input) {
                s += s1;
            }

            char[] arr = s.toCharArray();
            playground[i] = arr;
        }

        int[] ourPos = new int[2];

        for (int row = 0; row < playground.length; row++) {
            for (int col = 0; col < playground[row].length; col++) {
                if (playground[row][col] == OUR_SYMBOL) {
                    ourPos[0] = row;
                    ourPos[1] = col;
                }
            }
        }

        String command = scan.nextLine();

        int opponentsCount = 3;
        int touchCount = 0;
        int moves = 0;

        while (!command.equals(FINISH_COMMAND)) {
            switch (command) {
                case UP_COMMAND:
                    int row = ourPos[0];
                    int col = ourPos[1];

                    try {
                        if (playground[row - 1][col] != OBSTACLE_SYMBOL) {

                            if (playground[row - 1][col] == OPPONENTS_SYMBOL) {
                                touchCount++;
                                opponentsCount--;
                            }
                            playground[row - 1][col] = OUR_SYMBOL;
                            playground[row][col] = '-';

                            ourPos[0] = row - 1;
                            moves++;
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case DOWN_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (playground[row + 1][col] != OBSTACLE_SYMBOL) {

                            if (playground[row + 1][col] == OPPONENTS_SYMBOL) {
                                touchCount++;
                                opponentsCount--;
                            }
                            playground[row + 1][col] = OUR_SYMBOL;
                            playground[row][col] = '-';

                            ourPos[0] = row + 1;
                            moves++;
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case LEFT_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (playground[row][col - 1] != OBSTACLE_SYMBOL) {

                            if (playground[row][col - 1] == OPPONENTS_SYMBOL) {
                                touchCount++;
                                opponentsCount--;
                            }
                            playground[row][col - 1] = OUR_SYMBOL;
                            playground[row][col] = '-';

                            ourPos[1] = col - 1;
                            moves++;
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
                case RIGHT_COMMAND:
                    row = ourPos[0];
                    col = ourPos[1];

                    try {
                        if (playground[row][col + 1] != OBSTACLE_SYMBOL) {

                            if (playground[row][col + 1] == OPPONENTS_SYMBOL) {
                                touchCount++;
                                opponentsCount--;
                            }
                            playground[row][col + 1] = OUR_SYMBOL;
                            playground[row][col] = '-';

                            ourPos[1] = col + 1;
                            moves++;
                        }
                    } catch (IndexOutOfBoundsException ignored) {}
                    break;
            }

            if (opponentsCount <= 0) {
                break;
            }

            command = scan.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d ", touchCount);
        System.out.printf("Moves made: %d", moves);
    }
}
