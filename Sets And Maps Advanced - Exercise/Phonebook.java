package com.company.SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] contactInput = scan.nextLine().split("-");

        Map<String, String> contactNumber = new HashMap<>();

        while (!contactInput[0].equals("search")) {
            String name = contactInput[0];
            String number = contactInput[1];

            contactNumber.putIfAbsent(name, "");
            contactNumber.put(name, number);

            contactInput = scan.nextLine().split("-");
        }

        String searchContact = scan.nextLine();

        while (!searchContact.equals("stop")) {
            if (contactNumber.containsKey(searchContact)) {
                System.out.printf("%s -> %s%n", searchContact, contactNumber.get(searchContact));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchContact);
            }

            searchContact = scan.nextLine();
        }
    }
}
