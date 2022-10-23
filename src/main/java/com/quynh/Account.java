package com.quynh;


import java.util.Scanner;

public class Account {
    // Class variable
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    // Class constructor
    public Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    // Function for depositing money
    private void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    // Function for withdrawing money
    private void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    // Function for showing the previous transaction
    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Function for calculating interest of current funds after a number of years
    private void calculateInterest(int years) {
        double interestRate = 0.0615;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The accrued rate of this year is: " + 100 * interestRate);
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // Function showing the main menu
    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            switch (option) {
                // Case A allows user to check balance
                case 'A':
                    System.out.println("=========================");
                    System.out.println("Balance: " + balance);
                    System.out.println("=========================");
                    System.out.println();
                    break;
                // Cade B allows user to make a deposit
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                // Case C allows user to make a withdrawal
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;
                // Case D allows user to view previous transaction
                case 'D':
                    System.out.println("=========================");
                    getPreviousTransaction();
                    System.out.println("=========================");
                    System.out.println();
                    break;
                // Case E allows user to calculate the interest
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                // Case F allows user to exit
                case 'F':
                    System.out.println("=========================");
                    break;
                // Default case to let user know they have entered invalid option
                default:
                    System.out.println("Error: Please enter A, B, C, D, E, or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us");
    }

}
