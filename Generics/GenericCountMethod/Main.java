package com.company.Generics.GenericCountMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();

            Box<String> box = new Box<>(text);

            boxes.add(box);
        }

        Box<String> boxToCompare = new Box<>(scan.nextLine());

        int counter = 0;
        for (Box<String> box : boxes) {
            int result = box.compareTo(boxToCompare);

            if (result > 0) {
                counter++;
            }
        }

        System.out.println(counter);

        // not tested in Judge - System under maintenance
    }
}
