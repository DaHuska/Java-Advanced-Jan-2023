package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        for (int row = 0; row < matrix.length; row++) {
            char endChars = (char) ('a' + row);

            for (int col = 0; col < matrix[row].length; col++) {
                char middleChar = (char) ('a' + row + col);

                matrix[row][col] = endChars + String.valueOf(middleChar) + endChars;

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}