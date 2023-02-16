package com.company.ExamPreparation;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bombs {

    public static final String DATURA_BOMB = "Datura Bombs";
    public static final String CHERRY_BOMB = "Cherry Bombs";
    public static final String SMOKE_BOMB = "Smoke Decoy Bombs";

    public static final String SUCCEED_MSG = "Bene! You have successfully filled the bomb pouch!";
    public static final String FAILED_MSG = "You don't have enough materials to fill the bomb pouch.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstSequence = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] secondSequence = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();

        Map<String, Integer> bombPouch = new LinkedHashMap<>();
        bombPouch.put(DATURA_BOMB, 0);
        bombPouch.put(CHERRY_BOMB, 0);
        bombPouch.put(SMOKE_BOMB, 0);

        for (int i = 0; i < firstSequence.length; i++) {
            bombEffects.offer(firstSequence[i]);
        }
        for (int i = 0; i < secondSequence.length; i++) {
            bombCasings.push(secondSequence[i]);
        }

        while (bombCasings.size() > 0 && bombEffects.size() > 0) {
            int sum = bombCasings.peek() + bombEffects.peek();

            if (sum == 40) {
                bombPouch.put(DATURA_BOMB, bombPouch.get(DATURA_BOMB) + 1);
            } else if (sum == 60) {
                bombPouch.put(CHERRY_BOMB, bombPouch.get(CHERRY_BOMB) + 1);
            } else if (sum == 120) {
                bombPouch.put(SMOKE_BOMB, bombPouch.get(SMOKE_BOMB) + 1);
            } else {
                bombCasings.push(bombCasings.pop() - 5);
                continue;
            }

            bombCasings.pop();
            bombEffects.poll();

            if (bombPouch.size() >= 3) {
                if (checkIsPouchFull(bombPouch)) {
                    break;
                }
            }
        }

        if (checkIsPouchFull(bombPouch)) {
            System.out.println(SUCCEED_MSG);
        } else {
            System.out.println(FAILED_MSG);
        }

        if (!bombEffects.isEmpty()) {
            System.out.print("Bomb Effects: ");

            while (bombEffects.size() > 1) {
                System.out.print(bombEffects.poll() + ", ");
            }
            System.out.println(bombEffects.poll());
        } else {
            System.out.println("Bomb Effects: empty");
        }

        if (!bombCasings.isEmpty()) {
            System.out.print("Bomb Casings: ");

            while (bombCasings.size() > 1) {
                System.out.print(bombCasings.pop() + ", ");
            }
            System.out.println(bombCasings.pop());
        } else {
            System.out.println("Bomb Casings: empty");
        }

        printBombs(CHERRY_BOMB, bombPouch.get(CHERRY_BOMB));
        printBombs(DATURA_BOMB, bombPouch.get(DATURA_BOMB));
        printBombs(SMOKE_BOMB, bombPouch.get(SMOKE_BOMB));
    }

    public static boolean checkIsPouchFull(Map<String, Integer> bombPouch) {
        for (Map.Entry<String, Integer> entry : bombPouch.entrySet()) {
            if (entry.getValue() < 3) {
                return false;
            }
        }

        return true;
    }

    public static void printBombs(String bomb, int count) {
        System.out.printf("%s: %d%n", bomb, count);
    }
}
