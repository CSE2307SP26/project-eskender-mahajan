package main;

import java.util.Scanner;

public class MainMenu {

    private static final int EXIT_SELECTION = 5;
	private static final int MAX_SELECTION = 5;

	private BankAccount userAccount;
    private TransactionHistory transactionHistory;
    private Customer customer;
    private Scanner keyboardInput;

    public MainMenu() {
        this.userAccount = new BankAccount(0.0);
        this.transactionHistory = new TransactionHistory(userAccount);
        this.keyboardInput = new Scanner(System.in);
        this.customer = new Customer();
    }

    public void displayOptions() {
        System.out.println("Welcome to the 237 Bank App!");
        
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. View transaction history");
        System.out.println("4. Make another account");
        System.out.println("5. Exit the app");

    }

    public int getUserSelection(int max) {
        int selection = -1;
        while(selection < 1 || selection > max) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
        }
        return selection;
    }

    public void processInput(int selection) {
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
                System.out.println("Thank you!");
                break;
        }
    }

    public void performDeposit() {
        double depositAmount = -1;
        while(depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextDouble();
        }
        transactionHistory.deposit(depositAmount);
    }
    public void performWithdrawal() {
        double withdrawalAmount = -1;
        while(withdrawalAmount < 0) {
            System.out.print("How much would you like to withdraw: ");
            withdrawalAmount = keyboardInput.nextDouble();
        }
        transactionHistory.withdrawal(withdrawalAmount);
    }
    public void viewTransactionHistory() {
        double[] transactions = transactionHistory.returnTransactionHistory();
        for(double transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public void makeAnotherAccount() {
        System.out.println("Created a new account with a starting balance of $0.00!");
        double startingBalance = 0.0;
        customer.createBankAccount(startingBalance);
    }
    public void run() {
        int selection = -1;
        while(selection != EXIT_SELECTION) {
            displayOptions();
            selection = getUserSelection(MAX_SELECTION);
            processInput(selection);
        }
    }

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
