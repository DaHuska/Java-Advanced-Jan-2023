package com.company.Generics.GenericBox;

import java.util.Scanner;

public class Main {
    public static <T> void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            T data = (T) scan.nextLine();

            Box<T> box = new Box<>(data);
            System.out.println(box.toString());
        }
    }
}
