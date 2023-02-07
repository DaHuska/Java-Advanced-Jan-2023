package com.company.Generics.GenericSwapMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static <E> void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<E> texts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            E data = (E) scan.nextLine();

            texts.add(data);
        }

        Box<E> box = new Box<>(texts);

        int[] swapIndexes = Arrays.stream(scan.nextLine().split("\\s+"))
        .mapToInt(Integer::parseInt).toArray();

        swap(box, swapIndexes[0], swapIndexes[1]);

        texts.forEach(text -> System.out.printf("%s: %s%n", text.getClass().getName(), text));
    }

    public static <E> void swap(Box<E> box, int firstIndex, int secondIndex) {
        E firstElement = box.getBoxes().get(firstIndex);
        E secondElement = box.getBoxes().get(secondIndex);

        box.getBoxes().set(firstIndex, secondElement);
        box.getBoxes().set(secondIndex, firstElement);
    }
}
