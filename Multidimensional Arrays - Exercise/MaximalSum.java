package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

    public static int[][] fillIntMatrix(String regexSplitter) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(regexSplitter)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static void main(String[] args) {

        int[][] matrix = fillIntMatrix("\\s+");

        int maxMatrixDimensions = 3;

        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[maxMatrixDimensions][maxMatrixDimensions];

        int currSum = 0;
        int[][] currMatrix = new int[maxMatrixDimensions][maxMatrixDimensions];

        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                for (int i = 0; i < 3; i++) {
                    currMatrix[i][0] = matrix[row + i][col];
                    currSum += currMatrix[i][0];

                    currMatrix[i][1] = matrix[row + i][col + 1];
                    currSum += currMatrix[i][1];

                    currMatrix[i][2] = matrix[row + i][col + 2];
                    currSum += currMatrix[i][2];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;

                    for (int i = 0; i < currMatrix.length; i++) {
                        for (int g = 0; g < currMatrix[i].length; g++) {
                            maxMatrix[i][g] = currMatrix[i][g];
                        }
                    }
                }
                currSum = 0;
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        for (int[] rows : maxMatrix) {
            for (int cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }
}
