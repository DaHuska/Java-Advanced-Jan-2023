package com.company.SetsAndMaps;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputInfo = scan.nextLine().split(",\\s+");

        Map<String, List<String>> shopProducts = new TreeMap<>();

        while (!inputInfo[0].equals("Revision")) {
            String shop = inputInfo[0];
            String product = inputInfo[1];
            String price = inputInfo[2];

            shopProducts.putIfAbsent(shop, new ArrayList<>());
            shopProducts.get(shop).add(product);
            shopProducts.get(shop).add(price);

            inputInfo = scan.nextLine().split(",\\s+");
        }

        shopProducts
                .forEach((key, value) -> {
                    System.out.printf("%s->%n", key);
                    for (int i = 0; i < value.size(); i+=2) {
                        double price = Double.parseDouble(value.get(i + 1));

                        System.out.printf("Product: %s, Price: %.1f%n", value.get(i), price);
                    }
                });
    }
}
