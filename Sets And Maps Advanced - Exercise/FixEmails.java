package com.company.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        Map<String, String> nameEmail = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scan.nextLine();

            nameEmail.putIfAbsent(name, "");
            nameEmail.put(name, email);

            name = scan.nextLine();
        }

        nameEmail
                .entrySet()
                .removeIf(email -> email.getValue().endsWith("us") ||
                        email.getValue().endsWith("uk") ||
                        email.getValue().endsWith("com"));
        nameEmail
                .forEach((user, email) -> {
                    System.out.printf("%s -> %s%n", user, email);
                });
    }
}
