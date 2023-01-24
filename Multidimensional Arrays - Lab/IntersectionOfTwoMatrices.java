package com.company.Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        char[][] finalMatrix = new char[firstMatrix.length][firstMatrix[0].length];

        for (int row = 0; row < firstMatrix.length; row++) {
            String[] inputSymbols = scan.nextLine().split("\\s+");
            firstMatrix[row] = String.join("", inputSymbols).toCharArray();
        }
        for (int row = 0; row < secondMatrix.length; row++) {
            String[] inputSymbols = scan.nextLine().split("\\s+");
            secondMatrix[row] = String.join("", inputSymbols).toCharArray();
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    finalMatrix[row][col] = '*';
                } else {
                    finalMatrix[row][col] = firstMatrix[row][col];
                }
            }
        }
        for (char[] row : finalMatrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
