package com.company.Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputNames = scan.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> kidsNames = new ArrayDeque<>();

        Collections.addAll(kidsNames, inputNames);

        while (kidsNames.size() > 1) {

            for (int i = 1; i < tossCount; i++) {
                kidsNames.offer(kidsNames.poll());
            }

            System.out.printf("Removed %s%n", kidsNames.poll());
        }

        System.out.printf("Last is %s%n", kidsNames.peek());
    }
}
