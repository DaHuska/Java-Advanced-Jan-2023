package com.company.ExamPreparation;

import java.util.Scanner;

public class Snake {

    public static final char SNAKE_SYMBOL = 'S';
    public static final char FOOD_SYMBOL = '*';
    public static final char BURROW_SYMBOL = 'B';

    public static final String UP_COMMAND = "up";
    public static final String DOWN_COMMAND = "down";
    public static final String LEFT_COMMAND = "left";
    public static final String RIGHT_COMMAND = "right";

    public static final String GAME_OVER = "Game over!";
    public static final String WON_GAME = "You won! You fed the snake.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lairDimensions = Integer.parseInt(scan.nextLine());

        char[][] lair = new char[lairDimensions][lairDimensions];

        int[] snakeStartPos = new int[2];

        for (int i = 0; i < lairDimensions; i++) {
            char[] arr = scan.nextLine().toCharArray();

            if (snakeStartPos[0] == 0 && snakeStartPos[1] == 0) {
                for (int g = 0; g < arr.length; g++) {
                    if (arr[g] == 'S') {
                        snakeStartPos[0] = i;
                        snakeStartPos[1] = g;
                        break;
                    }
                }
            }

            lair[i] = arr;
        }

        String command = scan.nextLine();

        int eatenFood = 0;
        while (eatenFood < 10) {
            switch (command) {
                case UP_COMMAND:
                    int row = snakeStartPos[0];
                    int col = snakeStartPos[1];
                    boolean isBurrowFound = false;

                    try {
                        if (lair[row - 1][col] == FOOD_SYMBOL) {
                            eatenFood++;
                        }
                        if (lair[row - 1][col] == BURROW_SYMBOL) {
                            lair[row - 1][col] = '.';

                            for (int i = 0; i < lairDimensions; i++) {
                                for (int g = 0; g < lairDimensions; g++) {
                                    if (lair[i][g] == BURROW_SYMBOL) {
                                        snakeStartPos[0] = i;
                                        snakeStartPos[1] = g;

                                        lair[i][g] = SNAKE_SYMBOL;
                                        isBurrowFound = true;
                                    }
                                }
                            }
                        }

                        if (!isBurrowFound) {
                            lair[row - 1][col] = SNAKE_SYMBOL;
                            snakeStartPos[0] = row - 1;
                            snakeStartPos[1] = col;
                        }
                        lair[row][col] = '.';
                    } catch (IndexOutOfBoundsException exception) {
                        lair[row][col] = '.';
                        printResults(GAME_OVER, lair, eatenFood);
                        return;
                    }
                    break;
                case DOWN_COMMAND:
                    row = snakeStartPos[0];
                    col = snakeStartPos[1];
                    isBurrowFound = false;

                    try {
                        if (lair[row + 1][col] == FOOD_SYMBOL) {
                            eatenFood++;
                        }
                        if (lair[row + 1][col] == BURROW_SYMBOL) {
                            lair[row + 1][col] = '.';

                            for (int i = 0; i < lairDimensions; i++) {
                                for (int g = 0; g < lairDimensions; g++) {
                                    if (lair[i][g] == BURROW_SYMBOL) {
                                        snakeStartPos[0] = i;
                                        snakeStartPos[1] = g;

                                        lair[i][g] = SNAKE_SYMBOL;
                                        isBurrowFound = true;
                                    }
                                }
                            }
                        }

                        if (!isBurrowFound) {
                            lair[row + 1][col] = SNAKE_SYMBOL;
                            snakeStartPos[0] = row + 1;
                            snakeStartPos[1] = col;
                        }
                        lair[row][col] = '.';
                    } catch (IndexOutOfBoundsException exception) {
                        lair[row][col] = '.';
                        printResults(GAME_OVER, lair, eatenFood);
                        return;
                    }

                    break;
                case LEFT_COMMAND:
                    row = snakeStartPos[0];
                    col = snakeStartPos[1];
                    isBurrowFound = false;

                    try {
                        if (lair[row][col - 1] == FOOD_SYMBOL) {
                            eatenFood++;
                        }
                        if (lair[row][col - 1] == BURROW_SYMBOL) {
                            lair[row][col - 1] = '.';

                            for (int i = 0; i < lairDimensions; i++) {
                                for (int g = 0; g < lairDimensions; g++) {
                                    if (lair[i][g] == BURROW_SYMBOL) {
                                        snakeStartPos[0] = i;
                                        snakeStartPos[1] = g;

                                        lair[i][g] = SNAKE_SYMBOL;
                                        isBurrowFound = true;
                                    }
                                }
                            }
                        }

                        if (!isBurrowFound) {
                            lair[row][col - 1] = SNAKE_SYMBOL;
                            snakeStartPos[0] = row;
                            snakeStartPos[1] = col - 1;
                        }
                        lair[row][col] = '.';
                    } catch (IndexOutOfBoundsException exception) {
                        lair[row][col] = '.';
                        printResults(GAME_OVER, lair, eatenFood);
                        return;
                    }

                    break;
                case RIGHT_COMMAND:
                    row = snakeStartPos[0];
                    col = snakeStartPos[1];
                    isBurrowFound = false;

                    try {
                        if (lair[row][col + 1] == FOOD_SYMBOL) {
                            eatenFood++;
                        }
                        if (lair[row][col + 1] == BURROW_SYMBOL) {
                            lair[row][col + 1] = '.';

                            for (int i = 0; i < lairDimensions; i++) {
                                for (int g = 0; g < lairDimensions; g++) {
                                    if (lair[i][g] == BURROW_SYMBOL) {
                                        snakeStartPos[0] = i;
                                        snakeStartPos[1] = g;

                                        lair[i][g] = SNAKE_SYMBOL;
                                        isBurrowFound = true;
                                    }
                                }
                            }
                        }

                        if (!isBurrowFound) {
                            lair[row][col + 1] = SNAKE_SYMBOL;
                            snakeStartPos[0] = row;
                            snakeStartPos[1] = col + 1;
                        }
                        lair[row][col] = '.';
                    } catch (IndexOutOfBoundsException exception) {
                        lair[row][col] = '.';
                        printResults(GAME_OVER, lair, eatenFood);
                        return;
                    }

                    break;
            }

            if (eatenFood >= 10) {
                break;
            }

            command = scan.nextLine();
        }

        printResults(WON_GAME, lair, eatenFood);
    }

    public static void printResults(String msg, char[][] lair, int foodEaten) {
        System.out.println(msg);
        System.out.printf("Food eaten: %d%n", foodEaten);

        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                System.out.print(lair[row][col]);
            }
            System.out.println();
        }
    }
}