package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private static final int EXIT_SELECTION = 6;
	private static final int MAX_SELECTION = 6;

	private BankAccount userAccount;
    private Customer customer;
    private Scanner keyboardInput;
    private boolean introMenu;

    public MainMenu() {
        
        this.keyboardInput = new Scanner(System.in);
        this.userAccount = null;
        this.customer = null; 
        this.introMenu = false;
    }
    public void run() {
        while(true){
            if(!introMenu) {
                displayInitialOptions();
                int selection = getUserSelection(2);
                processInitialInput(selection);
            }
            else {
                displayAccountOptions();
                int selection = getUserSelection(MAX_SELECTION);
                processAccountInput(selection);
                if(selection == EXIT_SELECTION) {
                    break;
                }
            }
        }
    }

    public void displayInitialOptions() {
        System.out.println("Welcome to the 237 Bank App!");
        System.out.println("1. Create an account");

    }
    public void processInitialInput(int selection) {
        switch (selection) {
            case 1:
                createAccount();
                break;
        }
    }
    public void createAccount() {
        System.out.print("Enter your name: ");
        String name = keyboardInput.next();
        customer = new Customer(name);
        userAccount = customer.getAccounts().get(0);
        introMenu = true;
    }

    public void displayAccountOptions() {
        System.out.println("Welcome to your account, " + customer.getName() + "!");
        
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. View transaction history");
        System.out.println("4. Make another account");
        System.out.println("5. Switch accounts");
        System.out.println("6. Exit the app");

    }
    public void processAccountInput(int selection) {
        switch (selection) {
            case 1:
                performDeposit();
                break;
            case 2:
                performWithdrawal();
                break;
            case 3:
                viewTransactionHistory();
                break;
            case 4:
                makeAnotherAccount();
                break;
            case 5:
                switchToAnotherAccount();
                break;
            case 6:
                System.out.println("Thank you!");
                break;
        }
    }

    public int getUserSelection(int max) {
        int selection = -1;
        while(selection < 1 || selection > max) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
        }
        return selection;
    }

    public void performDeposit() {
        double depositAmount = -1;
        while(depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextDouble();
        }
        userAccount.deposit(depositAmount);
    }
    public void performWithdrawal() {
        double withdrawalAmount = -1;
        while(withdrawalAmount < 0) {
            System.out.print("How much would you like to withdraw: ");
            withdrawalAmount = keyboardInput.nextDouble();
        }
        userAccount.withdraw(withdrawalAmount);
    }
    public void viewTransactionHistory() {
        ArrayList<Double> transactions = userAccount.returnTransactionHistory();
        for(double transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public void makeAnotherAccount() {
        System.out.println("Created a new account with a starting balance of $0.00!");
        customer.createBankAccount();
    }
    public void switchToAnotherAccount() {
        if(customer == null) {
            System.out.println("Unable to switch accounts. No customer found.");
            return;
        }
        ArrayList<BankAccount> accounts = customer.getAccounts();
        if(accounts.size() == 0) {
            System.out.println("Unable to switch accounts. No accounts found.");
            return;
        }
        System.out.println("Pick an account to switch to: ");
        for(int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". Account Balance: " + accounts.get(i).getBalance());
        }
        int selection = getUserSelection(accounts.size());
        userAccount = accounts.get(selection - 1);
        introMenu = true;
    }


    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
