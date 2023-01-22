package com.company.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Map<String, Map<String, Integer>> usernameIpMsgs = new TreeMap<>();

        while (!input[0].equals("end")) {
            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            usernameIpMsgs.putIfAbsent(user, new LinkedHashMap<>());
            usernameIpMsgs.get(user).putIfAbsent(ip, 0);

            int getCount = usernameIpMsgs.get(user).get(ip);
            usernameIpMsgs.get(user).put(ip, getCount + 1);

            input = scan.nextLine().split("\\s+");
        }

        usernameIpMsgs
                .forEach((username, ipCount) -> {
                    System.out.printf("%s: %n", username);

                    AtomicInteger counter = new AtomicInteger();
                    ipCount
                            .forEach((ip, count) -> {
                                if (counter.intValue() == ipCount.size() - 1) {
                                    System.out.printf("%s => %d.%n", ip, count);
                                } else {
                                    System.out.printf("%s => %d, ", ip, count);
                                }

                                counter.getAndIncrement();
                            });
                });
    }
}