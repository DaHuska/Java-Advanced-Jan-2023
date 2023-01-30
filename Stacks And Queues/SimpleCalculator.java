package com.company.Stacks_And_Queues;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        List<String> list = new ArrayList<>(Arrays.asList(input));

        Collections.reverse(list);

        ArrayDeque<String> expressions = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            expressions.push(list.get(i));
        }

        while (expressions.size() > 1) {
            int firstNum = Integer.parseInt(expressions.pop());
            String operator = expressions.pop();
            int secondNum = Integer.parseInt(expressions.pop());

            int result = 0;
            switch (operator) {
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
            }

            expressions.push(String.valueOf(result));
        }
        System.out.println(expressions.peek());
    }
}