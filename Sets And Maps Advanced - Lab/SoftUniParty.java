package com.company.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String guest = scan.nextLine();

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            char firstChar = guest.charAt(0);

            if (Character.isDigit(firstChar)) {
                vipGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }

            guest = scan.nextLine();
        }

        String guestArrived = scan.nextLine();

        while (!guestArrived.equals("END")) {
            if (regularGuests.contains(guestArrived)) {
                regularGuests.remove(guestArrived);
            } else if (vipGuests.contains(guestArrived)) {
                vipGuests.remove(guestArrived);
            }

            guestArrived = scan.nextLine();
        }
        int unarrivedCount = vipGuests.size() + regularGuests.size();

        System.out.println(unarrivedCount);
        vipGuests.forEach(vipGuest -> System.out.println(vipGuest));
        regularGuests.forEach(regularGuest -> System.out.println(regularGuest));
    }
}
