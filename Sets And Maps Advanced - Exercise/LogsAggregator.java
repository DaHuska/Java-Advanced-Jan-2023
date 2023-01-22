package com.company.SetsAndMaps;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int logsCount = Integer.parseInt(scan.nextLine());

        Map<String, Set<String>> userIp = new TreeMap<>();
        Map<String, Integer> userDuration = new LinkedHashMap<>();

        for (int i = 0; i < logsCount; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            userIp.putIfAbsent(user, new TreeSet<>());
            userIp.get(user).add(ip);

            userDuration.putIfAbsent(user, 0);
            userDuration.put(user, userDuration.get(user) + duration);
        }

        AtomicInteger counter = new AtomicInteger();
        userIp
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s: %d %s", entry.getKey(), userDuration.get(entry.getKey()), entry.getValue());

                    System.out.println();
                    counter.getAndIncrement();
                });
    }
}
