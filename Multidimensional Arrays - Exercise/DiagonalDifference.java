package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

    public static int[][] fillIntMatrix(String regexSplitter) {
        Scanner scan = new Scanner(System.in);
        int dimensions = Integer.parseInt(scan.nextLine());

        int rows = dimensions;
        int cols = dimensions;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(regexSplitter)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = fillIntMatrix("\\s+");

        int primaryDiagSum = 0;
        int secondaryDiagSum = 0;

        // Sum the elements of the primary diagonal
        for (int row = 0; row < matrix.length; row++) {
            int col = row;

            primaryDiagSum += matrix[row][col];
        }

        for (int row = 0; row < matrix.length; row++) {
            int col = matrix[row].length - 1 - row;

            secondaryDiagSum += matrix[row][col];
        }

        int sumDiff = Math.abs(primaryDiagSum - secondaryDiagSum);
        System.out.println(sumDiff);
    }
}