package com.company.Stacks_And_Queues;

import com.sun.jdi.ArrayReference;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<Integer> indexOpenBracket = new ArrayDeque<>();
        ArrayDeque<String> expressions = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                indexOpenBracket.push(i);
            } else if (input.charAt(i) == ')') {
                int currCloseBracket = i;
                int currOpenBracket = indexOpenBracket.pop();

                String currExpression = input.substring(currOpenBracket, currCloseBracket + 1);
                expressions.offer(currExpression);
            }
        }
        while (expressions.size() > 0) {
            System.out.println(expressions.poll());
        }
    }
}