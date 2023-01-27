package com.company.Multidimensional_Arrays;

import java.util.Scanner;

public class FillTheMatrix {

    public static void printIntMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");

        int dimensions = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimensions][dimensions];

        int counter = 1;
        switch (pattern) {
            case "A":
                for (int col = 0; col < matrix.length; col++) {
                    for (int row = 0; row < matrix[col].length; row++, counter++) {
                        matrix[row][col] = counter;
                    }
                }
                break;
            case "B":
                for (int col = 0; col < matrix.length; col++) {
                    for (int row = 0; row < matrix[col].length; row++, counter++) {
                        if (col % 2 == 0) {
                            matrix[row][col] = counter;
                        } else {
                            matrix[matrix.length - row - 1][col] = counter;
                        }
                    }
                }
                break;
        }
        printIntMatrix(matrix);
    }
}
