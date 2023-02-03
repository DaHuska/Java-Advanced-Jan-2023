package com.company.DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String CREATE = "Create";
    private static final String DEPOSIT = "Deposit";
    private static final String SET_INTEREST = "SetInterest";
    private static final String GET_INTEREST = "GetInterest";
    private static final Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] command = scan.nextLine().split("\\s+");

        while (!command[0].equals("End")) {
            String result = "";

            switch (command[0]) {
                case CREATE:
                    result = createAccount();
                    break;
                case DEPOSIT:
                    result = deposit(command);
                    break;
                case SET_INTEREST:
                    result = setInterest(command);
                    break;
                case GET_INTEREST:
                    result = getInterest(command);
                    break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }

            command = scan.nextLine().split("\\s+");
        }
    }

    private static String getInterest(String[] command) {
        int id = Integer.parseInt(command[1]);
        int years = Integer.parseInt(command[2]);

        if (!accounts.containsKey(id)) {
            return "Account does not exist";
        }

        double result = accounts.get(id).getInterestRate(years);

        return String.format("%.2f", result);
    }

    private static String setInterest(String[] tokens) {
        double interest = Double.parseDouble(tokens[1]);

        Account.setInterestRate(interest);

        return "";
    }

    private static String deposit(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);

        if (!accounts.containsKey(id)) {
            return "Account does not exist";
        }

        accounts.get(id).deposit(amount);

        return String.format("Deposited %.0f to ID%d", amount, id);
    }

    private static String createAccount() {
        Account account = new Account();

        int id = account.getId();

        Main.accounts.put(id, account);

        return String.format("Account ID%d created", id);
    }
}
