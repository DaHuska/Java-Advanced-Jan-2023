package com.company.Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimalNum = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();

        if (decimalNum == 0) {
            System.out.println(0);
            return;
        }

        while (decimalNum > 0) {
            int binaryDigit = decimalNum % 2;
            decimalNum /= 2;

            binaryNum.push(binaryDigit);
        }

        while (binaryNum.size() > 0) {
            System.out.print(binaryNum.pop() + "");
        }
    }
}