package com.company.Multidimensional_Arrays;

import com.company.Methods;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = Methods.fillIntMatrix(",\\s+");

        //Print matrix's rows and columns count
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        //Sum all elements in the matrix and print them
        int elemsSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                elemsSum += matrix[row][col];
            }
        }
        System.out.println(elemsSum);
    }
}
