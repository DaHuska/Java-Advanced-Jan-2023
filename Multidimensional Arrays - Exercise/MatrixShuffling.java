package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    public static void printIntMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }

        String[] command = scan.nextLine().split("\\s+");

        while (!command[0].equals("END")) {
            switch (command[0]) {
                case "swap":
                    if (command.length != 5) {
                        System.out.println("Invalid input!");
                        break;
                    }
                    int row1 = Integer.parseInt(command[1]);
                    int col1 = Integer.parseInt(command[2]);
                    int row2 = Integer.parseInt(command[3]);
                    int col2 = Integer.parseInt(command[4]);

                    if (row1 > rows || row1 < 0 || row2 > rows || row2 < 0
                            || col1 > cols || col1 < 0 || col2 > cols || col2 < 0) {

                        System.out.println("Invalid input!");
                        break;
                    } else {
                        String holder = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = holder;

                        printIntMatrix(matrix);
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            command = scan.nextLine().split("\\s+");
        }
    }
}
