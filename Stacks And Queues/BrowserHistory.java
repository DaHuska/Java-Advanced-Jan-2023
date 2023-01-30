package com.company.Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = scan.nextLine();

        ArrayDeque<String> previousUrls = new ArrayDeque<>();
        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (previousUrls.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    previousUrls.pop();
                    System.out.println(previousUrls.peek());
                }
            } else {
                previousUrls.push(url);
                System.out.println(previousUrls.peek());
            }
            url = scan.nextLine();
        }
    }
}
