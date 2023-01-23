package com.company.Multidimensional_Arrays;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputDimensions = scan.nextLine().split("\\s+");

        int firstRows = Integer.parseInt(inputDimensions[0]);
        int firstCols = Integer.parseInt(inputDimensions[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            String[] parts = scan.nextLine().split("\\s+");

            for (int col = 0; col < firstCols; col++) {
                firstMatrix[row][col] = Integer.parseInt(parts[col]);
            }
        }

        inputDimensions = scan.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(inputDimensions[0]);
        int secondCols = Integer.parseInt(inputDimensions[1]);

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int row = 0; row < secondMatrix.length; row++) {
            String[] parts = scan.nextLine().split("\\s+");

            for (int col = 0; col < secondMatrix[row].length; col++) {
                secondMatrix[row][col] = Integer.parseInt(parts[col]);
            }
        }

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
