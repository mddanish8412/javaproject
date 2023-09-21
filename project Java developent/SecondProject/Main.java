package MySecondProject;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to My HDFC Bank ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    double balance = bankAccount.getBalance();
                    System.out.println("Your balance is $" + balance);
                    break;
                case "2":
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                    break;
                case "3":
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
                    }
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("11101350912", "MD DANISH ANSARi", 20000.0);
        ATM atm = new ATM(account);
        atm.run();
    }
}

