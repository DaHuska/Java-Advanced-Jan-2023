package com.company.DefiningClasses.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String COMPANY_INFO = "company";
    private static final String POKEMON_INFO = "pokemon";
    private static final String PARENTS_INFO = "parents";
    private static final String CHILDREN_INFO = "children";
    private static final String CAR_INFO = "car";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();

        Map<String, Person> personInfo = new LinkedHashMap<>();

        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split("\\s+");
            String personName = tokens[0];

            personInfo.putIfAbsent(personName, new Person(personName));

            switch (tokens[1]) {
                case COMPANY_INFO:
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Person.Company company = new Person.Company(companyName, department, salary);
                    personInfo.get(personName).setCompany(company);
                    break;
                case POKEMON_INFO:
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);

                    personInfo.get(personName).addPokemon(pokemon);
                    break;
                case PARENTS_INFO:
                    String parentName = tokens[2];
                    String parentBday = tokens[3];

                    Person.Parent parent = new Person.Parent(parentName, parentBday);

                    personInfo.get(personName).addParent(parent);
                    break;
                case CHILDREN_INFO:
                    String childName = tokens[2];
                    String childBday = tokens[3];

                    Person.Child child = new Person.Child(childName, childBday);

                    personInfo.get(personName).addChild(child);
                    break;
                case CAR_INFO:
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Person.Car car = new Person.Car(carModel, carSpeed);

                    personInfo.get(personName).setCar(car);
                    break;
            }

            personInfo.put(personName, personInfo.get(personName));
            inputLine = scan.nextLine();
        }

        String personInfoRequest = scan.nextLine();

        printPersonInfo(personInfo.get(personInfoRequest));
    }

    public static void printPersonInfo(Person person) {
        System.out.printf("%s%n", person.getName());

        System.out.println("Company:");
        if (person.getCompany() != null) {
            System.out.println(person.getCompany().toString());
        }

        System.out.println("Car:");
        if (person.getCar() != null) {
            System.out.println(person.getCar().toString());
        }

        System.out.println("Pokemon:");
        if (person.getPokemons().size() > 0) {
            person.getPokemons()
                    .forEach(pokemon -> System.out.println(pokemon.toString()));
        }

        System.out.println("Parents:");
        if (person.getParents().size() > 0) {
            person.getParents()
                    .forEach(parent -> System.out.println(parent.toString()));
        }

        System.out.println("Children:");
        if (person.getChildren().size() > 0) {
            person.getChildren()
                    .forEach(child -> System.out.println(child.toString()));
        }
    }
}