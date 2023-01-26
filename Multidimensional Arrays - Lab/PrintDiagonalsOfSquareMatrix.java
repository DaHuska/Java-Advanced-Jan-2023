package com.company.Multidimensional_Arrays;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {

    public static String[][] fillStringMatrix(String regexSplitter) {
        Scanner scan = new Scanner(System.in);
        int dimensions = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[dimensions][dimensions];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split(regexSplitter);
        }
        return matrix;
    }

    public static void printDiagonals(List<String> diagonal) {
        for (String value : diagonal) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {

        String[][] matrix = fillStringMatrix("\\s+");

        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal.add(matrix[i][i]);
        }

        int column = 0;
        for (int i = matrix.length - 1; i >= 0; i--, column++) {
            secondDiagonal.add(matrix[i][column]);
        }

        printDiagonals(firstDiagonal);
        System.out.println();
        printDiagonals(secondDiagonal);
    }
}
