package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static int[][] fillIntMatrix(String regexSplitter) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(regexSplitter)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static void printIntMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = fillIntMatrix(",\\s+");
        int[][] biggestMatrix = new int[2][2];

        int currSum = 0;
        int biggestSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                currSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currSum > biggestSum) {
                    biggestSum = currSum;

                    biggestMatrix[0][0] = matrix[row][col];
                    biggestMatrix[0][1] = matrix[row][col + 1];
                    biggestMatrix[1][0] = matrix[row + 1][col];
                    biggestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        printIntMatrix(biggestMatrix);
        System.out.println(biggestSum);
    }
}
