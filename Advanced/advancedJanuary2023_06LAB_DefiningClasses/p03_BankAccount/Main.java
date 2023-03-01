package advancedJanuary2023_06LAB_DefiningClasses.p03_BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<BankAccount> accountsList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {

                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    System.out.printf("Account ID%d created%n",bankAccount.getId());
                    accountsList.add(bankAccount);


                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    double amount = Double.parseDouble(command[2]);

                    if (accountsList.size() > (id - 1)){
                        accountsList.get(id -1).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(interest);

                    break;
                case "GetInterest":
                    id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);
                    if (accountsList.size() > (id - 1)){
                        double sum = accountsList.get(id -1).getInterest(years);
                        System.out.printf("%.2f%n", sum);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;

            }

            input = scanner.nextLine();
        }

    }
}
