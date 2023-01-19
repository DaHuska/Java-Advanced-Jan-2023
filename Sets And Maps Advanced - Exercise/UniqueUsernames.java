package com.company.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputTimes = Integer.parseInt(scan.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < inputTimes; i++) {
            String username = scan.nextLine();

            usernames.add(username);
        }

        usernames
                .forEach(username -> System.out.println(username));
    }
}
