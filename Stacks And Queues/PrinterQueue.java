package com.company.Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String filename = scan.nextLine();

        ArrayDeque<String> files = new ArrayDeque<>();

        while (!filename.equals("print")) {

            if (filename.equals("cancel")) {
                if (files.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", files.poll());
                }
            } else {
                files.offer(filename);
            }

            filename = scan.nextLine();
        }

        while (files.size() > 0) {
            System.out.println(files.poll());
        }
    }
}
