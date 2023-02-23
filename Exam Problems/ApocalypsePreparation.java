package com.company;

import java.util.*;

public class ApocalypsePreparation {

    public static final String PATCH_ITEM = "Patch";
    public static final String BANDAGE_ITEM = "Bandage";
    public static final String MEDKIT_ITEM = "MedKit";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] textilesArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] medicamentsArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();

        Map<String, Integer> itemsCount = new TreeMap<>();
        itemsCount.put(MEDKIT_ITEM, 0);
        itemsCount.put(BANDAGE_ITEM, 0);
        itemsCount.put(PATCH_ITEM, 0);

        for (int i = 0; i < textilesArr.length; i++) {
            textilesQueue.offer(textilesArr[i]);
        }
        for (int i = 0; i < medicamentsArr.length; i++) {
            medicamentsStack.push(medicamentsArr[i]);
        }

        while (textilesQueue.size() > 0 && medicamentsStack.size() > 0) {
            int result = textilesQueue.peek() + medicamentsStack.peek();

            if (result == 30) {
                itemsCount.put(PATCH_ITEM, itemsCount.get(PATCH_ITEM) + 1);

                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (result == 40) {
                itemsCount.put(BANDAGE_ITEM, itemsCount.get(BANDAGE_ITEM) + 1);

                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (result == 100) {
                itemsCount.put(MEDKIT_ITEM, itemsCount.get(MEDKIT_ITEM) + 1);

                textilesQueue.poll();
                medicamentsStack.pop();
            } else {
                if (result >= 100) {
                    int remaining = result - 100;

                    itemsCount.put(MEDKIT_ITEM, itemsCount.get(MEDKIT_ITEM) + 1);

                    textilesQueue.poll();
                    medicamentsStack.pop();

                    medicamentsStack.push(medicamentsStack.pop() + remaining);
                } else {
                    textilesQueue.poll();
                    medicamentsStack.push(medicamentsStack.pop() + 10);
                }
            }
        }

        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            printBothEmptyMsg();
        } else if (textilesQueue.isEmpty()) {
            printTextilesEmptyMsg();
        } else if (medicamentsStack.isEmpty()) {
            printMedicamentsEmptyMsg();
        }

        itemsCount
                .entrySet()
                .stream()
                .filter(item -> item.getValue() > 0)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(item -> System.out.printf("%s - %d%n", item.getKey(), item.getValue()));

        if (!textilesQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            while (textilesQueue.size() > 1) {
                System.out.print(textilesQueue.poll() + ", ");
            }
            System.out.println(textilesQueue.poll());
        } else if (!medicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            while (medicamentsStack.size() > 1) {
                System.out.print(medicamentsStack.poll() + ", ");
            }
            System.out.println(medicamentsStack.poll());
        }
    }

    public static void printTextilesEmptyMsg() {
        System.out.println("Textiles are empty.");
    }

    public static void printMedicamentsEmptyMsg() {
        System.out.println("Medicaments are empty.");
    }

    public static void printBothEmptyMsg() {
        System.out.println("Textiles and medicaments are both empty.");
    }
}