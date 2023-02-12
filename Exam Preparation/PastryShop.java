package com.company.ExamPreparation;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class PastryShop {

    public static final String BISCUIT = "Biscuit";
    public static final String CAKE = "Cake";
    public static final String PIE = "Pie";
    public static final String PASTRY = "Pastry";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> liquidsInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ingredientsInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Map<String, Integer> products = new LinkedHashMap<>();

        products.put(BISCUIT, 0);
        products.put(CAKE, 0);
        products.put(PIE, 0);
        products.put(PASTRY, 0);

        for (int i = 0; i < liquidsInput.size(); i++) {
            liquidsQueue.offer(liquidsInput.get(i));
        }
        for (int i = 0; i < ingredientsInput.size(); i++) {
            ingredientsStack.push(ingredientsInput.get(i));
        }

        while (ingredientsStack.size() > 0 && liquidsQueue.size() > 0) {
            int result = liquidsQueue.peek() + ingredientsStack.peek();
            String cookedProduct = "";

            if (result == 25) {
                cookedProduct = BISCUIT;
            } else if (result == 50) {
                cookedProduct = CAKE;
            } else if (result == 75) {
                cookedProduct = PASTRY;
            } else if (result == 100) {
                cookedProduct = PIE;
            }

            if (!cookedProduct.isEmpty()) {
                liquidsQueue.poll();
                ingredientsStack.pop();
                products.put(cookedProduct, products.get(cookedProduct) + 1);
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }

        AtomicBoolean areAllCooked = new AtomicBoolean(false);
        products.forEach((product, amount) -> {
            if (amount != 0) {
                areAllCooked.set(true);
            } else {
                areAllCooked.set(false);
            }
        });

        if (areAllCooked.get()) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (!liquidsQueue.isEmpty()) {
            while (liquidsQueue.size() > 1) {
                System.out.print(liquidsQueue.poll() + ", ");
            }
            System.out.println(liquidsQueue.poll());
        } else {
            System.out.println("none");
        }

        System.out.print("Ingredients left: ");
        if (!ingredientsStack.isEmpty()) {

            while (ingredientsStack.size() > 1) {
                System.out.print(ingredientsStack.pop() + ", ");
            }
            System.out.println(ingredientsStack.pop());
        } else {
            System.out.println("none");
        }

        products
                .forEach((product, amount) -> System.out.printf("%s: %d%n", product, amount));

        // 90/100
    }
}