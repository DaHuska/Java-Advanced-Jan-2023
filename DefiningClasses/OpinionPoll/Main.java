package com.company.DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCount = Integer.parseInt(scan.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < inputCount; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            persons.add(person);
        }

        persons
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
